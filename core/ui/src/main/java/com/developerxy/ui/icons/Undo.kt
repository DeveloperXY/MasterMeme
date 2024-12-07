package com.developerxy.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val UndoIcon: ImageVector
    get() {
        if (_Undo != null) {
            return _Undo!!
        }
        _Undo = ImageVector.Builder(
            name = "Undo",
            defaultWidth = 24.dp,
            defaultHeight = 10.dp,
            viewportWidth = 24f,
            viewportHeight = 10f
        ).apply {
            path(fill = SolidColor(Color(0xFFCCC2DC))) {
                moveTo(12.557f, 0f)
                curveTo(9.388f, 0f, 6.518f, 1.184f, 4.305f, 3.109f)
                lineTo(2.045f, 0.849f)
                curveTo(1.292f, 0.096f, 0f, 0.622f, 0f, 1.686f)
                verticalLineTo(8.372f)
                curveTo(0f, 9.029f, 0.538f, 9.568f, 1.196f, 9.568f)
                horizontalLineTo(7.881f)
                curveTo(8.946f, 9.568f, 9.484f, 8.276f, 8.73f, 7.523f)
                lineTo(6.446f, 5.238f)
                curveTo(8.109f, 3.851f, 10.225f, 2.99f, 12.569f, 2.99f)
                curveTo(16.349f, 2.99f, 19.614f, 5.19f, 21.168f, 8.372f)
                curveTo(21.491f, 9.041f, 22.257f, 9.376f, 22.962f, 9.137f)
                curveTo(23.811f, 8.862f, 24.242f, 7.893f, 23.859f, 7.08f)
                curveTo(21.802f, 2.894f, 17.521f, 0f, 12.557f, 0f)
                close()
            }
        }.build()

        return _Undo!!
    }

@Suppress("ObjectPropertyName")
private var _Undo: ImageVector? = null