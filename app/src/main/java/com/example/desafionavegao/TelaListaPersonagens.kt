package com.example.desafionavegao

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaListaPersonagens(
    onPersonagemClick: (Personagem) -> Unit
) {
    val personagens = listOf(
        Personagem("Legolas", "Elfo", "Ranger", 12),
        Personagem("Aragorn", "Humano", "Guerreiro", 15),
        Personagem("Gimli", "Anão", "Guerreiro", 10),
        Personagem("Gandalf", "Mago", "Mago", 20),
        Personagem("Frodo", "Hobbit", "Ladrão", 5),
        Personagem("Boromir", "Humano", "Guerreiro", 11),
        Personagem("Elrond", "Elfo", "Clérigo", 18),
        Personagem("Galadriel", "Elfo", "Maga", 19),
        Personagem("Sam", "Hobbit", "Jardineiro", 4),
        Personagem("Merry", "Hobbit", "Escudeiro", 3),
        Personagem("Pippin", "Hobbit", "Escudeiro", 3),
        Personagem("Thorin", "Anão", "Rei", 14)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Personagens",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(personagens) { personagem ->
                PersonagemCard(
                    personagem = personagem,
                    onClick = { onPersonagemClick(personagem) }
                )
            }
        }
    }
}

@Composable
fun PersonagemCard(
    personagem: Personagem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${personagem.nome} (${personagem.especie})",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}