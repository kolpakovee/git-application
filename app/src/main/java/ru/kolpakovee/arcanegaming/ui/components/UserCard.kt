package ru.kolpakovee.arcanegaming.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.kolpakovee.arcanegaming.R
import ru.kolpakovee.arcanegaming.data.User

@Composable
fun UserCard(
    user: User,
    modifier: Modifier = Modifier,
    onUserClicked: (User) -> Unit
) {
    Card(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable { onUserClicked(user) },
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = modifier
                    .size(75.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(user.avatarUrl)
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.ic_launcher_foreground),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(id = R.string.load_failed),
                contentScale = ContentScale.Crop
            )

            user.login?.let {
                Text(text = it)
            }

            user.score?.let {
                Text(text = it.toString(), color = Color(0xFFFFA500))
            }
        }
    }
}