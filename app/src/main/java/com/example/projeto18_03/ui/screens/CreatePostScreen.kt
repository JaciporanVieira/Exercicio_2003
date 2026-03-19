package com.example.projeto18_03.ui.screens

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projeto18_03.viewmodels.PostViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CreatePostScreen(
    navController: NavController,
    snackbarHostState: SnackbarHostState,
    viewModel: PostViewModel = viewModel()
){
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    var scope = rememberCoroutineScope()
    LaunchedEffect(viewModel.errorMessage) {
        viewModel.errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearError()
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Criar novo Post")

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it},
            label = { Text("Titulo")},
            modifier = Modifier.fillMaxWidth(),
            enabled =  !viewModel.isLoading
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = body,
            onValueChange = { body = it},
            label = { Text("Conteudo")},
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            enabled =  !viewModel.isLoading,
            maxLines = 5,
            singleLine = false,
            textStyle = LocalTextStyle.current.copy(
                lineHeight = 20.sp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor =  Color.Gray,
                unfocusedBorderColor = Color.LightGray


            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if(title.isNotBlank() && body.isNotBlank()){
                    scope.launch{
                        val success = viewModel.createPost(title, body)
                        if(success){
                            snackbarHostState.showSnackbar("Post criado com sucesso")
                            navController.popBackStack()
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !viewModel.isLoading
        ) {
            Text("Criar Post")
        }
    }




}