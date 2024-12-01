package com.developerxy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

@Composable
fun MasterMemeTheme(content: @Composable () -> Unit) {
    val colorScheme = darkColorScheme(
        primary = primary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        surface = surface,
        surfaceContainer = surfaceContainer,
        onSurfaceVariant = onSurfaceVariant,
        outline = outline,
        outlineVariant = outlineVariant
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

