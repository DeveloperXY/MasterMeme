package com.developerxy.yourmemes.ui.components.templatechooser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.developerxy.yourmemes.ui.components.CircularRevealAnimation
import com.developerxy.yourmemes.ui.model.MemeTemplate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseTemplateBottomSheet(
    modifier: Modifier = Modifier,
    memeTemplates: List<MemeTemplate>,
    onHidden: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var isSearching by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }
    val filteredTemplates = remember(query) {
        memeTemplates.filter { it.name.contains(query, ignoreCase = true) }
    }

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
                        resultsCount = filteredTemplates.size,
                        query = query,
                        onQueryChanged = { query = it },
                        onClear = { query = "" },
                        onHide = { isSearching = false }
                    )
                }
            )

            Spacer(Modifier.height(42.dp))
            MemeTemplatesGrid(templates = if (isSearching) filteredTemplates else memeTemplates)
        }
    }
}