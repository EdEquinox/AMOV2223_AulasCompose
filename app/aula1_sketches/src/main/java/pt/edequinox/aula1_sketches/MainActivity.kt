package pt.edequinox.aula1_sketches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.edequinox.aula1_sketches.ui.theme.AMOV2223_AulasComposeTheme
import pt.edequinox.aula1_sketches.ui.theme.AMOV2223_AulasComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMOV2223_AulasComposeTheme {
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Yellow//MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                } */
                /*Greeting(
                    name = "DEIS-AMOV"
                )*/
                MainScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 224, 32))
            .padding(16.dp)

    ) {
        Text(
            text = "HelloA $name!",
            modifier = modifier
        )
        Text(
            text = "HelloB $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AMOV2223_AulasComposeTheme {
        Greeting("Android")
    }
}