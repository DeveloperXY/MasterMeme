package com.developerxy.yourmemes.ui.components.templatechooser

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.developerxy.ui.theme.AppTypography
import com.developerxy.ui.theme.surface
import com.developerxy.ui.theme.surfaceContainer

@Composable
fun MemeTemplateSearchBar(
    modifier: Modifier = Modifier,
    resultsCount: Int,
    query: String,
    onQueryChanged: (String) -> Unit,
    onClear: () -> Unit,
    onHide: () -> Unit,
) {
    val color = remember { Animatable(surface) }
    LaunchedEffect(Unit) {
        color.animateTo(
            surfaceContainer,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    }

    Column {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .background(color.value),
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .requiredSize(16.dp)
                        .clickable {
                            onHide()
                        },
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Hide search field",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .requiredSize(16.dp)
                        .clickable {
                            onClear()
                        },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Hide search field",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            value = query,
            onValueChange = onQueryChanged,
            placeholder = {
                Text(
                    text = "Search for template...",
                    style = AppTypography.labelMedium.copy(
                        color = Color(0xFF444347)
                    )
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0xFF38343D)
            )
        )

        Spacer(Modifier.height(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = if (resultsCount == 0) "No memes found :(" else "$resultsCount templates",
            style = AppTypography.labelSmall.copy(
                color = Color(0xFF79747E)
            )
        )
    }
}