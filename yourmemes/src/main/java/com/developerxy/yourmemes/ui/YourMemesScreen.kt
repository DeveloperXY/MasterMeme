package com.developerxy.yourmemes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.developerxy.ui.MasterMemeIcons
import com.developerxy.ui.theme.AppTypography
import com.developerxy.yourmemes.ui.components.templatechooser.ChooseTemplateBottomSheet
import com.developerxy.yourmemes.ui.model.MemeTemplate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourMemesScreen(
    modifier: Modifier = Modifier,
    memeTemplates: List<MemeTemplate>,
    onAction: (YourMemesAction) -> Unit
) {
    var showTemplateChooser by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                title = {
                    Text(
                        "Your memes",
                        style = AppTypography.headlineLarge.copy(
                            color = Color(0xFFE6E0E9)
                        )
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showTemplateChooser = true
                onAction(YourMemesAction.OnCreateNewMeme)
            }) {
                Icon(
                    painter = painterResource(com.developerxy.ui.R.drawable.baseline_add_24),
                    contentDescription = "Create new meme",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    ) { padding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    modifier = Modifier.size(346.dp, 200.dp),
                    imageVector = MasterMemeIcons.NoMemes,
                    contentDescription = "No memes",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(32.dp))
                Text(
                    "Tap + button to create your first meme",
                    style = AppTypography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                )
            }
        }

        if (showTemplateChooser) {
            ChooseTemplateBottomSheet(
                memeTemplates = memeTemplates,
                onHidden = { showTemplateChooser = false }
            )
        }
    }
}