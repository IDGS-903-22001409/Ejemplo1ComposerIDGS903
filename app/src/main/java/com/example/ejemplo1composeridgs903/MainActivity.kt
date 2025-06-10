package com.example.ejemplo1composeridgs903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val Tarjetas : List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable."),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters."),
    PersonajeTarjeta("Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación."),
    PersonajeTarjeta("Bulma", "Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Zarbon", "Zarbon es uno de los secuaces de Freezer y un luchador poderoso."),
    PersonajeTarjeta("Dodoria", "Dodoria es otro secuaz de Freezer conocido por su brutalidad."),
    PersonajeTarjeta("Ginyu", "Ginyu es el líder del la élite de mercenarios de mayor prestigio del Ejército de Freeza, la cual lleva el nombre de Fuerzas Especiales Ginew en su honor[9]."),
    PersonajeTarjeta("Celula", "Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku por haber acabado con el Ejército del Listón Rojo, y con ello el sueño de todo villano: dominar el mundo. Es el antagonista principal del Arco de los Androides y Cell."),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(Tarjetas)
            }
        }
    }
}

data class PersonajeTarjeta (val tittle: String, val body: String)

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        // ImageHeroe()
        items(personajes){personaje ->
            MyPersonaje(personaje)
        }
    }
}

@Composable
fun MyPersonaje (personaje: PersonajeTarjeta){
    Card {
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation  = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        stage = RoundedCornerShape(16.dp)
        colors = CardDefaults.cardColors(containerColor = Color.White)
    }
    Row {
        ImageHeroe()
        Personajes(personaje)
    }
}

@Composable
fun Personaje(name: String, color: Color, style: androidx.compose.ui.text.TextStyle){
    Column {
        Text(text = name)
    }
}

@Composable
fun Personajes(personaje: PersonajeTarjeta)
{
    Column {
        Personaje(personaje.tittle, MaterialTheme.colorScheme.primary, MaterialTheme.typography.headlineMedium)
        Personaje(personaje.body, MaterialTheme.colorScheme.onBackground , MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ImageHeroe(){
    Image(painter = painterResource(id = R.drawable.goku_normal), contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary))

}

@Preview
@Composable
fun GreetingPreview() {
    Tarjeta(Tarjetas)
}