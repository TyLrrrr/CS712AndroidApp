package com.example.assignment2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //val people = listOf("Device Fragmentation", "OS Fragmentation", "Unstable and Dynamic Environment", "Rapid Changes", "Tool Support")

        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Tyler Sather",
                        modifier = Modifier.padding(innerPadding),
                        studentID = "1541040"
                    )
                    buttonExplicit(
                        LocalContext.current
                    )
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, studentID: String) {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.padding(top = 200.dp, bottom = 500.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_house_24),
                "Photo of Home",
                modifier = Modifier.width(100.dp).height(100.dp)
            )
            Text(
                text = "Hi, my name is $name!"
            )
            Text(
                text = "My student ID is $studentID"
            )
        }
    }
}
@Composable
fun buttonExplicit(context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        Button(
            onClick = {
                //Toast.makeText(context, "Hello World",Toast.LENGTH_LONG).show()
                context.startActivity(Intent(context, MainActivity2::class.java))
            }
        ) {
            Text("Explicit")
        }
    }
}



