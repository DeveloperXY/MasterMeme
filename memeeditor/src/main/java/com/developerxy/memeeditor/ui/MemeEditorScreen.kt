package com.developerxy.memeeditor.ui

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerxy.ui.MasterMemeIcons
import com.developerxy.ui.theme.AppTypography
import com.developerxy.ui.util.loadBitmapFromUri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemeEditorScreen(
    modifier: Modifier = Modifier,
    selectedTemplateResourcePath: String,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val templateBitmap =
        remember { context.loadBitmapFromUri(Uri.parse(selectedTemplateResourcePath)) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                title = {
                    Text(
                        text = "New meme",
                        textAlign = TextAlign.Center,
                        style = AppTypography.headlineLarge.copy(
                            color = Color(0xFFE6E0E9)
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = MasterMemeIcons.Undo,
                                contentDescription = "Undo",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                                    alpha = 0.3f
                                )
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = MasterMemeIcons.Redo,
                                contentDescription = "Redo",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                                    alpha = 0.3f
                                )
                            )
                        }
                    }

                    Row {
                        OutlinedButton(
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.outline
                            ),
                            onClick = {

                            }
                        ) {
                            Text(
                                modifier = Modifier.wrapContentSize(),
                                text = "Add text",
                                style = AppTypography.headlineMedium.copy(
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        FilledTonalButton(
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            onClick = {

                            }
                        ) {
                            Text(
                                modifier = Modifier.wrapContentSize(),
                                text = "Save meme",
                                style = AppTypography.headlineMedium.copy(
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            )
                        }
                    }
                }
            }
        }
    ) { padding ->
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
}