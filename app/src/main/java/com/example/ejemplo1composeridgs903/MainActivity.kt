package com.example.ejemplo1composeridgs903

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Card
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


private val Tarjetas : List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku","El protagonista de la serie, conocido por su gran poder y personalidad amigable."),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters."),
    PersonajeTarjeta("Broly","Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario."),
    PersonajeTarjeta("Gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Freezer","Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Piccolo","Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso y miembro de los Guerreros Z."),
    PersonajeTarjeta("Cell","Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku por haber acabado con el Ejército del Listón Rojo, y con ello el sueño de todo villano: dominar el mundo."),
    PersonajeTarjeta("Bardock","Es un saiyano de clase baja proveniente del Planeta Vegeta del Universo 7."),
    PersonajeTarjeta("Androide 13","Android 13 es un androide peligroso que aparece en la película \\\"El Regreso de Cooler\\\"."),
    PersonajeTarjeta("Raditz","Es el hijo de Bardock y Gine, y hermano mayor de Son Goku."),
)

data class PersonajeTarjeta(val title: String, val body: String)
/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(Tarjetas)
            }
        }
    }
}
@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        items(personajes) { personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun Personaje(name: String, color: Color, style: androidx.compose.ui.text.TextStyle,lines:Int = Int.MAX_VALUE){
    Text(text = name, color = color, style = style,maxLines = lines)
}
@Composable
fun MyPersonajes(personajes: PersonajeTarjeta) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {

        Row {
            ImageHeroe(personajes.title)
            Personajes(personajes)
        }
    }
}

@Composable
fun Personajes(personaje: PersonajeTarjeta) {
    var expanded by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .padding(start = 8.dp)
            .clickable { expanded = !expanded }
    ){
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineLarge)

        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
        if(expanded) Int.MAX_VALUE else 1
    }
}


@Composable
fun ImageHeroe(imageName : String){
    val contex = LocalContext.current
    val imageResId = remember (imageName){
        contex.resources.getIdentifier(imageName.lowercase(),"drawable",contex.packageName)
    }
    Image(painter = painterResource(id = imageResId), contentDescription = "Goku",
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary))
}

@Preview
@Composable
fun GreetingPreview() {
    Tarjeta(Tarjetas)
}