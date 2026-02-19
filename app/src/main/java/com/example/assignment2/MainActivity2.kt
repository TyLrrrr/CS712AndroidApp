package com.example.assignment2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val challenges = listOf("Device Fragmentation", "OS Fragmentation", "Unstable and Dynamic Environment", "Rapid Changes", "Tool Support")

        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        items(
                            challenges,
                        ){
                            ListItem(it)
                        }
                    }
                    buttonExplicit2(LocalContext.current)
                }
            }
        }
    }
}


@Composable
fun ListItem(name: String){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(12.dp))
    }
}

@Composable
fun buttonExplicit2(context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current

        Button(
            onClick = {
                //Toast.makeText(context, "Hello World",Toast.LENGTH_LONG).show()
                context.startActivity(Intent(context, MainActivity::class.java))
            }
        ) {
            Text("Main")
        }

    }
}