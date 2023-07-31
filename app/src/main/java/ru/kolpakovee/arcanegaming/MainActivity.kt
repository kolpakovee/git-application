package ru.kolpakovee.arcanegaming

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import ru.kolpakovee.arcanegaming.ui.GitApp
import ru.kolpakovee.arcanegaming.ui.components.WebViewComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitApp(onUserClicked = {
                ContextCompat.startActivity(
                    this,
                    Intent(Intent.ACTION_VIEW, Uri.parse(it.htmlUrl)),
                    null
                )
            }, onFileClicked = {
                ContextCompat.startActivity(
                    this,
                    Intent(Intent.ACTION_VIEW, Uri.parse(it.downloadUrl)),
                    null
                )
            })
        }
    }
}
