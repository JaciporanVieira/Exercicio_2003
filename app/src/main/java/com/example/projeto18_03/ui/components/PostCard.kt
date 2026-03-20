package com.example.projeto18_03.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.projeto18_03.data.models.Post

@Composable
fun PostCard(
    post: Post,
    onDeleteClick: (Int) -> Unit,
    onClick: (Post) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable{
                onClick(post)
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "ID: ${post.id}", modifier = Modifier.weight(1f))
                IconButton( onClick = {onDeleteClick(post.id)}) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Delete Post"
                    )
                }
            }
            Text(text = "Title: ${post.title}", modifier = Modifier.padding(top = 8.dp))
            Text(text = "Body: ${post.body}", modifier = Modifier.padding(top = 4.dp))





        }
    }
}