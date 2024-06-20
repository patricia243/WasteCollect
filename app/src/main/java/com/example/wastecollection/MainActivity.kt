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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Image(
                painter = painterResource(id = lescartesdechets),
                contentDescription = "Poubelle",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop,


            )
            Spacer(modifier = Modifier
                .height(16.dp))
            Text(
                text = "Cliques sur l'image  pour faire un choix sur le services ",
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
    Image(painter = painterResource (images__8_), contentDescription =null )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())

        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        

            Column {

                Text(
                    text = "ÉCO-COLLECTE",
                    color = Color.Black
                )

                Image(
                    painter = painterResource(id = images__10_),
                    contentDescription = "Photo 1",
                    modifier = Modifier

                        .clickable {
                            navController.navigate("interface1")
                        }
                        .size(width = 200.dp, height = 200.dp)
                )
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Column {
                Text(
                    text = "BIO - RECYCLE",
                    color = Color.Black
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
        Spacer(modifier = Modifier.padding(16.dp))

            Column {
                Text(

                    text = "COMPST-PLUS",
                    color = Color.Black
                )

                Image(
                    painter = painterResource(id = images__14_),
                    contentDescription = "Photo 3",
                    modifier = Modifier
                        .clickable {
                            navController.navigate("interface3")
                        }
                        .size(width = 200.dp, height = 200.dp)
                )


        }
        Spacer(modifier = Modifier.padding(16.dp))


        Column {

            Text(
                text ="RENOV - RECYCLAGE",
                color = Color.Black
            )
            Image(
                painter = painterResource(id = recycling_symbol2_svg),
                contentDescription = "Photo 4",
                modifier = Modifier
                    .clickable {
                        navController.navigate("interface4")
                    }
                    .size(width = 200.dp, height = 200.dp)
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))

            Column {
                Text(
                    text = "INDUS-COLLECTE",
                    color = Color.Black

                )
                Image(
                    painter = painterResource(id = images__9_),
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

            text = " ce service est Spécialisée dans la collecte régulière des déchets ménagers auprès des particuliers " +
                    "et des petits commerces. " +
                    "Elle assure une collecte fiable et respecte les normes environnementales. et voici les services:" +
                    "- Possibilité de collecte à des heures flexibles pour s'adapter aux besoins des clients\n" +
                    " - Utilisation de véhicules électriques ou hybrides pour réduire l'empreinte carbone\n" +
                    " - Programmes de sensibilisation auprès des clients sur les bonnes pratiques de tri et de réduction des déchets",
            color = Color.Black


        )
    }
}

@Composable
fun Interface2() {
    Image(painter = painterResource (images__8_), contentDescription =null )
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
    Image(painter = painterResource (images__8_), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = " - Mise en place de bacs de compostage individuels ou collectifs pour les clients\n" +
                    " - Formations et conseils sur le compostage à domicile\n" +
                    " - Possibilité de récupérer le compost produit par les clients\n"
        )

    }
}

@Composable
fun Interface4() {
    Image(painter = painterResource (images__10_), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = " Le services de Rénov-Recyclage vous proposez plusieurs fonction pour trie vos dechets : " +
                    " - Propositions de solutions de tri et de valorisation sur les chantiers\n" +
                    " - Services de déconstruction sélective pour maximiser le recyclage\n" +
                    " - Remise de rapports détaillés sur le taux de recyclage atteint"

        )
    }
}

@Composable
fun Interface5() {
    Image(painter = painterResource (images__8_), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Indus-Collecte est un services specialiser dans " +
                    "Collecte et élimination des déchets industriels :\n" +
                    "Cette entreprise offre des services de collecte et " +
                    "d'élimination sûre des déchets industriels dans le respect des normes environnementales." +
                    " Elle travaille en étroite collaboration avec les entreprises pour personnaliser ses services." +
                    "et voici le services :  " +
                    "1- Conseillers dédiés pour accompagner les entreprises dans la gestion de leurs déchets\n" +
                    "2- Possibilité de collecte en dehors des heures ouvrées pour minimiser les perturbations\n" +
                    "3- Mise en place d'indicateurs de performance environnementale pour les clients",
            color = Color.Black
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