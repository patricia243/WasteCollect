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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Bienvenue sur WasteCollect",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )


            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )


            Image(
                painter = painterResource(id = lescartesdechets),
                contentDescription = "Poubelle",
                modifier = Modifier
                    .size(200.dp),
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
    //Image(painter = painterResource (images__8_), contentDescription =null )
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
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
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
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
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
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
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
                color = Color.Black,
                fontWeight = FontWeight.Bold
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
                    color = Color.Black,
                    fontWeight = FontWeight.Bold

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

            text = "L'éco-collecte permet de valoriser ces différents types de déchets de manière responsable, contribuant ainsi à la protection de l'environnement et à la création d'une économie plus durable." +
                    "" +
                    "Raisons importantes de faire de l'éco-collecte :\n" +
                    "\n" +
                    "Protection de l'environnement : L'éco-collecte permet de détourner les déchets des sites d'enfouissement et des incinérateurs, réduisant ainsi l'impact négatif sur l'environnement.\n" +
                    "Conservation des ressources : Le recyclage des matériaux permet de préserver les ressources naturelles en évitant l'extraction de nouvelles matières premières.\n" +
                    "Réduction des émissions de gaz à effet de serre : Le recyclage nécessite moins d'énergie que la production à partir de matières premières vierges, ce qui réduit les émissions de gaz à effet de serre.\n" +
                    "Économie circulaire : L'éco-collecte s'inscrit dans une logique d'économie circulaire, où les déchets deviennent des ressources pour de nouveaux produits.\n" +
                    "Sensibilisation et responsabilité environnementale : L'éco-collecte encourage les citoyens à adopter des comportements plus responsables envers l'environnement.\n" +
                    "" +
                    "Types de déchets traités par l'éco-collecte :\n" +
                    "\n" +
                    "1.Papier et carton : journaux, magazines, emballages en carton, etc.\n" +
                    "2.Plastique : bouteilles, emballages, sacs, etc.\n" +
                    "3.Verre : bouteilles, pots, etc.\n" +
                    "4.Métaux : boîtes de conserve, canettes, ferraille, etc.\n" +
                    "5.Déchets électroniques : ordinateurs, téléphones, appareils électriques, etc.\n" +
                    "6.Textiles : vêtements, chaussures, tissus, etc.\n" +
                    "7.Déchets organiques : restes alimentaires, déchets de jardin, etc.\n" +
                    "8.Déchets dangereux : piles, peintures, produits chimiques, etc. ",

            color = Color.Black


        )
    }
}

@Composable
fun Interface2() {
    //Image(painter = painterResource (images__8_), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(

            text = "Le bio-recyclage joue donc un rôle essentiel dans la gestion durable des déchets en valorisant les ressources organiques tout en réduisant leur impact environnemental." +
                    "Les raisons importantes pour le bio-recyclage sont les suivantes :" +
                    "A.Réduction des déchets organiques enfouis :\n" +
                    "1.Les déchets organiques comme les restes alimentaires et les déchets de jardin représentent une part importante des déchets ménagers.\n" +
                    "2.Leur enfouissement en décharge contribue à la production de méthane, un gaz à effet de serre puissant.\n" +
                    "3.Le bio-recyclage permet de détourner ces déchets organiques des sites d'enfouissement.\n" +
                    "" +
                    "B.alorisation des déchets organiques :\n" +
                    "1.Par le compostage ou la méthanisation, les déchets organiques sont transformés en ressources utiles.\n" +
                    "2.Le compost produit peut être utilisé pour fertiliser les sols et améliorer la qualité des terres agricoles ou des espaces verts.\n" +
                    "3.Le biogaz issu de la méthanisation peut être valorisé pour produire de l'énergie renouvelable.\n" +
                    "" +
                    "C.Économie circulaire et réduction des impacts :\n" +
                    "1.Le bio-recyclage s'inscrit dans une logique d'économie circulaire, en réintégrant les nutriments des déchets organiques dans les cycles naturels.\n" +
                    "2.Cela permet de réduire les besoins en engrais chimiques et les impacts liés à leur production.\n" +
                    "3.De plus, le traitement des déchets organiques par compostage ou méthanisation a un impact environnemental moindre que l'enfouissement ou l'incinération.\n" +
                    "" +
                    "Les principaux types de déchets traités par le bio-recyclage sont :\n" +
                    "\n" +
                    "1.Restes alimentaires :\n" +
                    "2.Restes de repas, fruits et légumes, épluchures, etc.\n" +
                    "3.Déchets de jardin :\n" +
                    "4.Tonte de pelouse, feuilles mortes, branches, fleurs fanées, etc.\n" +
                    "5.Autres déchets organiques :\n" +
                    "6.Sciures de bois, litières animales, etc.",
            color = Color.Black

        )
    }
}

@Composable
fun Interface3() {
   // Image(painter = painterResource (images__8_), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Voici les raisons importantes pour le service de compost+ et les types de déchets qu'il traite :\n" +
                    "\n" +
                    "Raisons importantes du compost+ :\n" +
                    "\n" +
                    "A.compostage de proximité :\n" +
                    "1.Le compost+ permet aux citoyens de composter leurs déchets organiques à l'échelle locale, dans leur quartier ou leur communauté.\n" +
                    "2.Cela réduit les coûts et l'impact environnemental liés au transport des déchets vers des sites de compostage centralisés.\n" +
                    "" +
                    "B.Production de compost de qualité :\n" +
                    "1.Le compost+ valorise les déchets organiques en produisant du compost de haute qualité, adapté aux besoins des espaces verts et de l'agriculture urbaine.\n" +
                    "2.Ce compost local peut être facilement réinjecté dans les cycles de production alimentaire et d'entretien des espaces verts de proximité.\n" +
                    "C.Sensibilisation et éducation :\n" +
                    "1.Le compost+ implique directement les citoyens dans le processus de gestion des déchets organiques.\n" +
                    "2.Cela permet de les sensibiliser à l'importance du compostage et de l'économie circulaire.\n" +
                    "" +
                    "Types de déchets traités par le compost+ :\n" +
                    "\n" +
                    "1.Restes alimentaires :\n" +
                    "2.Épluchures, restes de repas, fruits et légumes\n" +
                    "3.Exclusion des viandes, poissons et produits laitiers\n" +
                    "4.Déchets de jardin :\n" +
                    "Tonte de pelouse, feuilles mortes, fleurs fanées\n" +
                    "Petits branchages et résidus de taille\n" +
                    "Autres déchets organiques :\n" +
                    "Serviettes en papier, mouchoirs\n" +
                    "Litières végétales pour animaux" ,
            color = Color.Black

        )

    }
}

@Composable
fun Interface4() {
    //Image(painter = painterResource (images__10_), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = " "

        )
    }
}

@Composable
fun Interface5() {
   // Image(painter = painterResource (images__8_), contentDescription =null )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "  ",
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