package com.developerxy.yourmemes.ui.components.templatechooser

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.developerxy.yourmemes.ui.model.MemeTemplate
import com.developerxy.ui.util.loadBitmapFromUri

@Composable
fun MemeTemplatesGrid(
    modifier: Modifier = Modifier,
    templates: List<MemeTemplate>,
    onTemplateSelected: (template: MemeTemplate) -> Unit,
) {
    val context = LocalContext.current
    val currentOnTemplateSelected by rememberUpdatedState(onTemplateSelected)

    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(templates.size) { index ->
            val template = templates[index]
            val templateUri = Uri.parse(template.resourcePath)
            val templateBitmap = context.loadBitmapFromUri(templateUri) ?: return@items

            Image(
                contentScale = ContentScale.Crop,
                bitmap = templateBitmap.asImageBitmap(),
                contentDescription = "Template ${index + 1}",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1f) // Ensure the height equals the width
                    .clickable {
                        currentOnTemplateSelected(template)
                    }
            )
        }
    }
}