package ru.kolpakovee.arcanegaming.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import ru.kolpakovee.arcanegaming.R
import ru.kolpakovee.arcanegaming.data.Content
import ru.kolpakovee.arcanegaming.data.FileType

@Composable
fun ContentCard(
    content: Content,
    modifier: Modifier = Modifier,
    onDirectoryClicked: (Content) -> Unit,
    onFileClicked: (Content) -> Unit
) {
    Card(
        modifier
            .fillMaxWidth()
            .clickable {
                if (content.type == FileType.DIRECTORY) onDirectoryClicked(content)
                else content.downloadUrl?.let { onFileClicked(content) }
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Image(
                bitmap = ImageBitmap.imageResource(id = if (content.type == FileType.FILE) R.drawable.file else R.drawable.folder),
                contentDescription = if (content.type == FileType.FILE) "file" else "dir",
                modifier = modifier.padding(10.dp)
            )

            content.name?.let {
                Text(text = it, modifier = modifier.padding(10.dp))
            }
        }
    }
}