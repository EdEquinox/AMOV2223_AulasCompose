package pt.edequinox.aula1_sketches

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pt.edequinox.aula1_sketches.ui.theme.SketchesFont


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController:NavHostController = rememberNavController()) {

    val currentScreen by navController.currentBackStackEntryAsState()
    var viewModel: DrawingViewModel? = null

    Scaffold (

        topBar = {
            if (currentScreen != null && Screens.valueOf(currentScreen!!.destination.route !!) != Screens.MENU){
                TopAppBar(
                    title = {
                        if (viewModel != null && currentScreen!!.destination.route == Screens.DRAWING.route)
                            Text(text = viewModel!!.sketchTitle.value, fontFamily = SketchesFont)
                        else
                            Text(text = "Sketches") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            navController.popBackStack() // nao anda p tras e p frente, mata logo
                            navController.navigate(Screens.DRAWING.route)
                        }) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "Add")
                        }
                    },
                    colors = largeTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White
                    ),
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.MENU.route,
            modifier = Modifier
                .padding(it)

        ) {
            composable(Screens.MENU.route) {
                Menu("Sketches",navController,
                    Screens.SOLID,
                    Screens.GALLERY,
                    Screens.CAMERA,
                    Screens.LIST
                )
            }
            composable(Screens.SOLID.route) {
//                ChooseBackground(
//                    sketchTitle = remember{mutableStateOf("Sketch Title")},
//                    colorR = remember{mutableStateOf(128)},
//                    colorG = remember{mutableStateOf(0)},
//                    colorB = remember{mutableStateOf(128)})

                ChooseBackground(viewModel = viewModel())
            }
            composable(Screens.GALLERY.route) {
                Greeting(name = "Gallery")
            }
            composable(Screens.CAMERA.route) {
                Greeting(name = "Camera")
            }
            composable(Screens.LIST.route) {
                Greeting(name = "List")
            }
            composable(Screens.DRAWING.route) {
                viewModel = viewModel()
                if (viewModel != null)
                    DrawingScreen(viewModel = viewModel!!)
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}