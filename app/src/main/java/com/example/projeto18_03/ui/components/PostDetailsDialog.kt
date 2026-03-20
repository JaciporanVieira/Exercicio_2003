package com.example.projeto18_03.ui.components

import android.app.Dialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.projeto18_03.data.models.Post

@Composable
fun PostDetailsDialog(
    post: Post,
    onDismiss: () -> Unit
    ) {
    Dialog(onDismissRequest =  onDismiss ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "ID: ${post.id}")
            Text(text = "Title: ${post.title}")
            Text(text = "Body: ${post.body}")

            Button(
                onDismiss,
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
            ) {
                Text("Fechar")
            }
        }
    }



}