package com.developerxy.yourmemes.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.developerxy.ui.theme.AppTypography

@Composable
fun ClickToExpandSearchBar(
    modifier: Modifier = Modifier,
    isSearching: Boolean,
    onToggleSearch: () -> Unit
) {
    Box(
        modifier = modifier
            .then(
                if (isSearching) {
                    Modifier.fillMaxWidth()
                } else {
                    Modifier.wrapContentWidth()
                }
            )
    ) {
        if (isSearching) {
            TextField(
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .requiredSize(16.dp)
                            .clickable {
                                onToggleSearch()
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
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color(0xFF38343D)
                )
            )
        }

        if (!isSearching) {
            IconButton(onClick = onToggleSearch) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}