package pt.edequinox.aula1_sketches

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Menu(
    navController: NavController?,
    vararg options: String
) {

    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Sketches",
            fontSize = 48.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .wrapContentWidth()
                .fillMaxHeight()
                .background(Color.DarkGray)
                .padding(4.dp)
                .background(Color.LightGray)
                .padding(24.dp)

        )
        Column(verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.75f)
        ) {
            options.forEach {
                Button(onClick = {
                    navController?.navigate(it)
                }) {
                    Text(text = it)
                }
            }
        }

    }
}

@Preview (showBackground = true)
@Composable
fun MenuPreview() {
    Menu(null, "Sketch 2", "Sketch 3")
}