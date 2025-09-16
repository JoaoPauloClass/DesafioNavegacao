package com.example.desafionavegao

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaDetalhesPersonagem(
    personagem: Personagem,
    onVoltarClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Detalhes do Personagem",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp, bottom = 32.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                DetalheItem(
                    label = "Nome",
                    valor = personagem.nome
                )

                Spacer(modifier = Modifier.height(12.dp))

                DetalheItem(
                    label = "Espécie",
                    valor = personagem.especie
                )

                Spacer(modifier = Modifier.height(12.dp))

                DetalheItem(
                    label = "Classe",
                    valor = personagem.classe
                )

                Spacer(modifier = Modifier.height(12.dp))

                DetalheItem(
                    label = "Level",
                    valor = personagem.level.toString()
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onVoltarClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .height(56.dp)
        ) {
            Text(
                text = "Voltar",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun DetalheItem(
    label: String,
    valor: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "$label: ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = valor,
            fontSize = 18.sp
        )
    }
}