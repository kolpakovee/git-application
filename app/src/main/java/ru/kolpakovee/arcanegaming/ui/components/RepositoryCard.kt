package ru.kolpakovee.arcanegaming.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.kolpakovee.arcanegaming.data.Repository

@Composable
fun RepositoryCard(
    repository: Repository,
    modifier: Modifier = Modifier,
    onRepositoryClicked: (Repository) -> Unit,
) {
    Card(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                onRepositoryClicked(repository)
            },
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repository.name?.let {
                    Text(text = it)
                }

                repository.forksCount?.let {
                    Text(
                        text = "$it\nForks",
                        color = Color.Black,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center
                    )
                }
            }
            repository.description?.let {
                Text(text = it, color = Color.Gray)
            }
        }
    }
}