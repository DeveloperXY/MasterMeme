package com.developerxy.memeeditor.ui.components.bottombar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerxy.ui.MasterMemeIcons
import com.developerxy.ui.theme.AppTypography

@Composable
fun StandbyBottomAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
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

@Preview(showBackground = true)
@Composable
fun StandbyBottomAppBarPreview(modifier: Modifier = Modifier) {
    StandbyBottomAppBar()
}