package com.developerxy.memeeditor

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.developerxy.ui.theme.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemeEditorScreen(
    modifier: Modifier = Modifier,
    selectedTemplateResourcePath: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "New meme",
                        textAlign = TextAlign.Center,
                        style = AppTypography.headlineLarge.copy(
                            color = Color(0xFFE6E0E9)
                        )
                    )
                }
            )
        },
    ) { padding ->

    }
}