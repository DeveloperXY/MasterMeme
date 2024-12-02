package com.developerxy.yourmemes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
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
import com.developerxy.yourmemes.ui.components.ClickToExpandSearchBar

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
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!isSearching) {
                    Column(modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)) {
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
                }

                ClickToExpandSearchBar(
                    isSearching = isSearching,
                    onToggleSearch = { isSearching = !isSearching }
                )
            }
            Spacer(Modifier.height(42.dp))
            MemeTemplatesGrid()
        }
    }
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