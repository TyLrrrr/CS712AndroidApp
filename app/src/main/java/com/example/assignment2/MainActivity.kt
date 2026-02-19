package com.example.assignment2

import android.widget.Toast
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Tyler Sather",
                        studentID = "1541040"
                    )
                    buttonExplicit()
                    buttonImplicit()
                    buttonServices()
                    buttonReciever()
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, studentID: String) {
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
fun buttonExplicit() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

@Composable
fun buttonImplicit() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                val intent = Intent("com.example.assignment2.OPEN_SECOND_ACTIVITY")
                context.startActivity(intent)
            }
        ) {
            Text("Implicit")
        }
    }
}


@Composable
fun buttonServices() {
    val context = LocalContext.current
    // on below line creating variable
    // for service status and button value.
    val serviceStatus = remember {
        mutableStateOf(false)
    }
    val buttonValue = remember {
        mutableStateOf("Start Service")
    }

    // on below line we are creating a column,
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier.fillMaxSize().padding(top = 200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {
            if (serviceStatus.value) {
                // service already running
                // stop the service
                serviceStatus.value = !serviceStatus.value
                buttonValue.value = "Start Service"
                context.stopService(Intent(context, MyService::class.java))
            } else {
                // service not running start service.
                serviceStatus.value = !serviceStatus.value
                buttonValue.value = "Stop Service"

                // starting the service
                context.startService(Intent(context, MyService::class.java))
            }

        }) {
            Text(
                text = buttonValue.value
            )
        }
    }
}

@Composable
fun buttonReciever() {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 300.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast.makeText(context, "Broadcast Received",Toast.LENGTH_LONG).show()

            }
        ) {
            Text("Receiver")
        }
    }
}


