import android.health.connect.datatypes.units.Length
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jorgearceruiz97.practica4_recyclerview.R
import com.jorgearceruiz97.practica4_recyclerview.data.Superhero


fun getSupeheroes(): ArrayList<Superhero>{
    var listaSuperHeroes = ArrayList<Superhero>()
    listaSuperHeroes.add(Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman))
    listaSuperHeroes.add(Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan))
    listaSuperHeroes.add(Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman))
    listaSuperHeroes.add(Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor))
    listaSuperHeroes.add(Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash))
    listaSuperHeroes.add(Superhero( "Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern))
    listaSuperHeroes.add(Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman))
    return listaSuperHeroes
}

@Preview(showBackground = true)
@Composable
fun SuperHeroView(){
    var context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
        items(getSupeheroes()){
            ItemHero(superhero = it, onItemSelected = {
                Toast.makeText(context, it.realName, Toast.LENGTH_SHORT)
            })
        }
    }
}

@Composable
fun SuperHeroViewColumn(){
    var context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)){
        items(getSupeheroes()){
            ItemHero(superhero = it, onItemSelected = {
                Toast.makeText(context, it.realName, Toast.LENGTH_SHORT)
            })
        }
    }
}

@Composable
fun SuperHeroVerticalGrid(){
    var context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Adaptive(130.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)){
            items(getSupeheroes()){
                ItemHero(superhero = it, onItemSelected = {Toast.makeText(context,it.realName,Toast.LENGTH_SHORT)})
            }
        }
}


@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp,Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(superhero) }
            .padding(4.dp)) {
        Column {
            Image(painter = painterResource(id = superhero.photo), contentDescription = "SuperHero Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                )

            Text(text = superhero.superheroName,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 16.sp,
                color = Color.Black)
            Text(
                text = superhero.realName,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                fontSize = 16.sp,
                color = Color.Black)
        }
    }
}
