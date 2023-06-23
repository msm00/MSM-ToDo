package com.msm.msmtodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msm.msmtodo.model.OracleDatabaseHelper
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
    // get the connection
//    val conn = OracleDBConnection.getConnection()
    val walletPath = "./Users/msm/AndroidStudioProjects/MSMToDo/Wallet"
    val helper = OracleDatabaseHelper(walletPath)

    val serviceName = "adwmsmdb_low"
    val connection = helper.getConnection(serviceName)

// Use the connection to execute queries or perform database operations
// Remember to properly close the connection when you're done
    connection.close()


//    println(conn.isValid(0))

    LazyColumn(modifier = Modifier.padding(8.dp)
        .background(MaterialTheme.colorScheme.outline),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        repeat(30) {
            item { ToDoItem(/*itemDesc = stringResource(R.string.describe_the_note)*/) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoItem(modifier: Modifier = Modifier) {
//    val TAG = "CHECKBOX ERR"
    val itemDesc = stringResource(id = R.string.describe_the_note)
    var checkState by remember { mutableStateOf(false)}

    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(all = 4.dp)
            .background(MaterialTheme.colorScheme.inversePrimary)
            .fillMaxWidth()
        ) {
        Text(
            text = itemDesc,
            modifier
                .padding(4.dp)
                .fillMaxWidth(0.8f),
            color = MaterialTheme.colorScheme.primary,
        )
        Checkbox(checked = checkState, onCheckedChange = { checkState = !checkState})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingItem(){
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier,
    )

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
        ToDoItem()
    }
}