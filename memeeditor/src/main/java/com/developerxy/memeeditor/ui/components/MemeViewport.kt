package com.developerxy.memeeditor.ui.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.developerxy.ui.util.loadBitmapFromUri

@Composable
fun MemeViewport(
    modifier: Modifier = Modifier,
    memeTemplateResourcePath: String
) {
    val context = LocalContext.current
    val templateBitmap =
        remember { context.loadBitmapFromUri(Uri.parse(memeTemplateResourcePath)) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        templateBitmap?.let { bitmap ->
            Image(
                contentScale = ContentScale.Fit,
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Current meme template",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(16.dp)
            )
        }
    }
}