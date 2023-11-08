package pt.edequinox.aula1_sketches

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        topBar = {
            Text(text = "Sketches")
        }
    ){
        NavHost(
            navController = navController,
            startDestination = "Menu"){
            composable("Menu"){
                Menu(navController, "Solid", "Camera", "List")
            }
            composable("Solid"){
                Greeting(name = "Solid")
            }
        }
    }

}

@Preview (showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}