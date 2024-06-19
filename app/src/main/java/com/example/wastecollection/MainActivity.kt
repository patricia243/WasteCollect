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
import androidx.compose.material3.Button
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
import com.example.wastecollection.R.drawable
import com.example.wastecollection.R.drawable.*
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
                    MyApp()
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
                text = "Bienvenue sur WasteCollection",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = lescartesdechets),
                contentDescription = "Poubelle",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop,


            )
            Spacer(modifier = Modifier
                .height(16.dp))
            Text(
                text = "Cliques sur la poubelle pour faire un choir",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black
            )
        }
    }
}


@Composable
fun DetailsScreen() {
    MyApp()

}

@Preview(showBackground = true)

@Composable
fun MainScreenPreview() {
    WasteApp()

    val navController = rememberNavController()
    MainScreen(navController)

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WasteCollectionTheme {
        WasteApp()
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
                painter = painterResource(id = accueil),
                contentDescription = "Photo 1",
                modifier = Modifier

                    .clickable {
                        navController.navigate("interface1")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )
            Image(
                painter = painterResource(id = choix),
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
                painter = painterResource(id = tri),
                contentDescription = "Photo 3",
                modifier = Modifier
                    .clickable {
                        navController.navigate("interface3")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )
            Image(
                painter = painterResource(id = lescartesdechets),
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
                painter = painterResource(id = commande),
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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(

            text = "Cette entreprise se spécialise dans la collecte régulière des déchets " +
                    "ménagers auprès des particuliers et des petits commerces. " +
                    "Ses équipes formées assurent une collecte fiable et le respect des normes environnementales.",
            // style = MaterialTheme.typography.headlineMedium,
            //color = Color.Black


        )
    }
}

@Composable
fun Interface2() {
    Column(
        modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "  Collecte et recyclage des déchets organiques :\n" +
                    "Spécialisée dans la collecte et le recyclage des déchets organiques " +
                    "tels que les restes alimentaires et les déchets de jardin, cette entreprise " +
                    "propose des solutions de compostage pour réduire l'impact environnemental."


        )

    }



}

@Composable
fun Interface3() {
    Image(painter = painterResource (nouriture), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = " Collecte et élimination des déchets dangereux :\n" +
                    "Cette entreprise gère la collecte et l'élimination sécurisée des déchets dangereux " +
                    "comme les produits chimiques, les piles et les médicaments." +
                    " Elle garantit la conformité aux réglementations en vigueur."
        )

    }
}

@Composable
fun Interface4() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = " Collecte et recyclage des déchets de construction :\n" +
                    "    Spécialisée dans la collecte et le recyclage des déchets de construction et " +
                    "de démolition, cette entreprise propose des solutions de valorisation des matériaux " +
                    "pour réduire les déchets.\n"

        )
    }
}

@Composable
fun Interface5() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = " Collecte et élimination des déchets industriels :\n" +
                    "Cette entreprise offre des services de collecte et " +
                    "d'élimination sûre des déchets industriels dans le respect des normes environnementales." +
                    " Elle travaille en étroite collaboration avec les entreprises pour personnaliser ses services."
        )

    }
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