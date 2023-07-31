package ru.kolpakovee.arcanegaming.ui.components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewComponent(url: String) {
    AndroidView(
        factory = { context ->
            val webView = WebView(context)
            webView.webViewClient = WebViewClient()
            webView.loadUrl(url)
            webView
        },
        modifier = Modifier.fillMaxSize()
    )
}