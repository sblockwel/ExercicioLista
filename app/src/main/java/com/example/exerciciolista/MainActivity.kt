package com.example.exerciciolista

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exerciciolista.ui.theme.ExercicioListaTheme
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExercicioListaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val produtos = listOf(
        Produto("Caneta", "Caneta da cor preta", 10.0),
        Produto("Teclado", "Teclado mecânico", 200.0),
        Produto(nome = "Mouse", valor = 150.0)
    )

    /*produtos.filter{it.descricao.startsWith("A")}
        .sortedBy{it.valor}*/

    LazyColumn() {
        items(items = produtos) { p ->
            ProdutoView(p)
        }
    }

}

@Composable
fun ProdutoView(produto: Produto) {
    val df = DecimalFormat("0.00")
    val context = LocalContext.current
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable { Toast.makeText(context, "Produto: ${produto.nome}",Toast.LENGTH_SHORT).show()}
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(text = produto.nome, style = MaterialTheme.typography.h5)
                Text(text = produto.descricao, style = MaterialTheme.typography.caption)
            }
            Text(
                text = "R$ ${df.format(produto.valor)}",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExercicioListaTheme {
        App()
    }
}