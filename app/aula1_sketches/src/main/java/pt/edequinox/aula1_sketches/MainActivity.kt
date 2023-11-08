package pt.edequinox.aula1_sketches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.edequinox.aula1_sketches.ui.theme.AMOV2223_AulasComposeTheme
import pt.edequinox.aula1_sketches.ui.theme.Pink80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMOV2223_AulasComposeTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    BasicExample()
//                }
                MainScreen()
            }
        }
    }
}

@Composable
fun BasicExample() {
    var counter by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .padding(16.dp).background(MaterialTheme.colorScheme.surface)
            .clickable { counter+= 2 }
            .background(Pink80),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have clicked the button $counter times")
        Button(onClick = { counter++ }) {
            Text(text = "Click me!")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AMOV2223_AulasComposeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun BasicExamplePreview() {
    AMOV2223_AulasComposeTheme {
        BasicExample()
    }
}