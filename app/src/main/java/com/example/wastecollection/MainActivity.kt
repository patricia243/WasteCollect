package com.example.wastecollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wastecollection.ui.theme.WasteCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WasteCollectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WasteApp()
                }
            }
        }
    }
}

@Composable
fun WasteApp() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()
        NavGraph(navController = navController)
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen1(navController) }
        composable("details") { DetailsScreen() }
    }
}

@Composable
fun MainScreen1(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable { navController.navigate("details") }
        ) {
            Text(
                text = "Bienvenue sur Waste",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.photo1),
                contentDescription = "Poubelle",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Cliques sur la poubelle pour faire un choir",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}


@Composable
fun DetailsScreen() {
    MyApp()

}

@Preview(showBackground = true)

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {

    val navController = rememberNavController()
    MainScreen(navController)

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WasteCollectionTheme {

    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(

        ) {
            Image(
                painter = painterResource(id = R.drawable.photo1),
                contentDescription = "Photo 1",
                modifier = Modifier

                    .clickable {
                        navController.navigate("interface1")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.photo2),
                contentDescription = "Photo 2",
                modifier = Modifier
                    .clickable {
                        navController.navigate("interface2")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )

        }
        Row(

        ) {
            Image(
                painter = painterResource(id = R.drawable.photo3),
                contentDescription = "Photo 3",
                modifier = Modifier
                    .clickable {
                        navController.navigate("interface3")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.photo4),
                contentDescription = "Photo 4",
                modifier = Modifier
                    .clickable {
                        navController.navigate("interface4")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )

        }
        Row(

        ) {
            Image(
                painter = painterResource(id = R.drawable.photo5),
                contentDescription = "Photo 5",
                modifier = Modifier
                    .clickable {
                        navController.navigate("interface5")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )
        }
    }

}


@Composable
fun Interface1() {
    Text(
        text = "Cliquez sur la poubelle pour faire un choix",
        style = MaterialTheme.typography.labelSmall
    )
}

@Composable
fun Interface2() {
    // Contenu de l'interface 2
}

@Composable
fun Interface3() {
    // Contenu de l'interface 3
}

@Composable
fun Interface4() {
    // Contenu de l'interface 4
}

@Composable
fun Interface5() {
    // Contenu de l'interface 5
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("interface1") { Interface1() }
        composable("interface2") { Interface2() }
        composable("interface3") { Interface3() }
        composable("interface4") { Interface4() }
        composable("interface5") { Interface5() }
    }
}