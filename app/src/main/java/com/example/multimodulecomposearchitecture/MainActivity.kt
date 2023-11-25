package com.example.multimodulecomposearchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.multimodulecomposearchitecture.di.AppModule
import com.example.multimodulecomposearchitecture.navigation.AppNavGraph
import com.example.multimodulecomposearchitecture.navigation.NavigationProvider
import com.example.multimodulecomposearchitecture.ui.theme.MultiModuleComposeArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleComposeArchitectureTheme {
                // A surface container using the 'background' color from the theme
            val navController = rememberNavController()
                App(navHostController = navController,navigationProvider)
            }
        }
    }
}

@Composable
fun App(navHostController: NavHostController,navigationProvider:NavigationProvider){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        
        AppNavGraph(navigationController = navHostController, navigationProvider= navigationProvider)
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
    MultiModuleComposeArchitectureTheme {
        Greeting("Android")
    }
}