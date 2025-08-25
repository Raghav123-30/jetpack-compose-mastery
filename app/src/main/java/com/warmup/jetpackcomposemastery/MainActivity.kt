package com.warmup.jetpackcomposemastery

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.warmup.jetpackcomposemastery.ui.theme.JetpackComposeMasteryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeMasteryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var counter by rememberSaveable { mutableIntStateOf(0) }
                    Column(modifier = Modifier.fillMaxSize().padding(innerPadding), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Counter value is $counter")
                        Spacer(modifier = Modifier.height(20.dp))
                        ChildComponent {
                            counter += 1
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChildComponent(onIncrement:()-> Unit){
    Button(onClick = onIncrement) {
        Text("Increment")
    }
}