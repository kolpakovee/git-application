package ru.kolpakovee.arcanegaming.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.kolpakovee.arcanegaming.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchLine(
    onSearchClicked: (String) -> Unit,
    onTextChanged: (String) -> Unit,
    request: String
) {
    TextField(
        value = request,
        onValueChange = { onTextChanged(it) },
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
        singleLine = true,
        label = { Text(text = stringResource(id = R.string.text_field_label)) },
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        trailingIcon = {
            IconButton(onClick = { onSearchClicked(request) }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        }
    )
}