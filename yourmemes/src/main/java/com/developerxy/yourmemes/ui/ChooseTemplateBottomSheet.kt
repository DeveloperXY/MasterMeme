package com.developerxy.yourmemes.ui

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.developerxy.ui.theme.AppTypography
import com.developerxy.ui.theme.surface
import com.developerxy.ui.theme.surfaceContainer
import com.developerxy.yourmemes.ui.components.CircularRevealAnimation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseTemplateBottomSheet(
    modifier: Modifier = Modifier,
    onHidden: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var isSearching by remember { mutableStateOf(false) }

    ModalBottomSheet(
        modifier = modifier,
        onDismissRequest = onHidden,
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            CircularRevealAnimation(
                revealPercentTarget = if (isSearching) 1f else 0f,
                startContent = {
                    ChooseTemplateHeader(
                        onSearchClicked = {
                            isSearching = true
                        }
                    )
                },
                endContent = {
                    MemeTemplateSearchBar(
                        onHide = {
                            isSearching = false
                        }
                    )
                }
            )

            Spacer(Modifier.height(42.dp))
            MemeTemplatesGrid()
        }
    }
}

@Composable
fun ChooseTemplateHeader(
    modifier: Modifier = Modifier,
    onSearchClicked: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Choose template",
                style = AppTypography.headlineSmall.copy(
                    color = Color(0xFFE6E0E9)
                )
            )
            Spacer(Modifier.height(12.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Choose template for your next meme masterpiece",
                style = AppTypography.labelSmall.copy(
                    color = Color.White
                )
            )
        }

        IconButton(onClick = onSearchClicked) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun MemeTemplateSearchBar(
    modifier: Modifier = Modifier,
    onHide: () -> Unit
) {
    val color = remember { Animatable(surface) }
    LaunchedEffect(Unit) {
        color.animateTo(
            surfaceContainer,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    }

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
        value = "",
        onValueChange = {},
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
}

@Composable
private fun MemeTemplatesGrid(modifier: Modifier = Modifier) {
    val templates = listOf(
        com.developerxy.ui.R.drawable.change_my_mind,
        com.developerxy.ui.R.drawable.chill_guy,
        com.developerxy.ui.R.drawable.disaster_girl,
        com.developerxy.ui.R.drawable.distracted_boyfriend,
        com.developerxy.ui.R.drawable.drake_hotline_bling,
        com.developerxy.ui.R.drawable.epic_handshake,
        com.developerxy.ui.R.drawable.left_exit_12_off_ramp,
        com.developerxy.ui.R.drawable.thinking_about_other_women,
        com.developerxy.ui.R.drawable.two_buttons,
    )

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(templates.size) { index ->
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = templates[index]),
                contentDescription = "Template ${index + 1}",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1f) // Ensure the height equals the width
            )
        }
    }
}