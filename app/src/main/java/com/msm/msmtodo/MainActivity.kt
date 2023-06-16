package com.msm.msmtodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msm.msmtodo.ui.theme.MSMToDoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MSMToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ToDoMainScreen()
                }
            }
        }
    }
}

@Composable
fun ToDoMainScreen() {
    LazyColumn {
        item { ToDoItem(itemDesc = "Describe the note") }
    }
}

@Composable
fun ToDoItem(itemDesc: String, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(all = 4.dp)
        ) {
        Text(
            text = itemDesc,
            modifier = modifier.padding(all = 4.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ToDoMainScreenPreview() {
    MSMToDoTheme {
        ToDoMainScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoItemPreview() {
    MSMToDoTheme {
        ToDoItem(itemDesc = "Bring the box")
    }
}