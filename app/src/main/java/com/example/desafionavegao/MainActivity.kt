package com.example.desafionavegao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.desafionavegao.ui.theme.DesafioNavegaçãoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesafioNavegaçãoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "lista_personagens"
                    ) {
                        composable("lista_personagens") {
                            TelaListaPersonagens(
                                onPersonagemClick = { personagem ->
                                    navController.navigate(
                                        "detalhes/${personagem.nome}/${personagem.especie}/${personagem.classe}/${personagem.level}"
                                    )
                                }
                            )
                        }

                        composable("detalhes/{nome}/{especie}/{classe}/{level}") { backStackEntry ->
                            val nome = backStackEntry.arguments?.getString("nome") ?: ""
                            val especie = backStackEntry.arguments?.getString("especie") ?: ""
                            val classe = backStackEntry.arguments?.getString("classe") ?: ""
                            val level = backStackEntry.arguments?.getString("level")?.toIntOrNull() ?: 0

                            TelaDetalhesPersonagem(
                                personagem = Personagem(nome, especie, classe, level),
                                onVoltarClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

// Data class para representar um personagem
data class Personagem(
    val nome: String,
    val especie: String,
    val classe: String,
    val level: Int
)