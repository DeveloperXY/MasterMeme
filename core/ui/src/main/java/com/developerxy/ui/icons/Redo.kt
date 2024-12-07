package com.developerxy.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val RedoIcon: ImageVector
    get() {
        if (_Redo != null) {
            return _Redo!!
        }
        _Redo = ImageVector.Builder(
            name = "Redo",
            defaultWidth = 24.dp,
            defaultHeight = 10.dp,
            viewportWidth = 24f,
            viewportHeight = 10f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFCCC2DC)),
            ) {
                moveTo(11.443f, 0f)
                curveTo(14.612f, 0f, 17.482f, 1.184f, 19.695f, 3.109f)
                lineTo(21.955f, 0.849f)
                curveTo(22.708f, 0.096f, 24f, 0.622f, 24f, 1.686f)
                verticalLineTo(8.372f)
                curveTo(24f, 9.029f, 23.462f, 9.568f, 22.804f, 9.568f)
                horizontalLineTo(16.119f)
                curveTo(15.054f, 9.568f, 14.516f, 8.276f, 15.269f, 7.523f)
                lineTo(17.554f, 5.238f)
                curveTo(15.891f, 3.851f, 13.775f, 2.99f, 11.431f, 2.99f)
                curveTo(7.651f, 2.99f, 4.386f, 5.19f, 2.832f, 8.372f)
                curveTo(2.509f, 9.041f, 1.743f, 9.376f, 1.038f, 9.137f)
                curveTo(0.189f, 8.862f, -0.242f, 7.893f, 0.141f, 7.08f)
                curveTo(2.198f, 2.894f, 6.479f, 0f, 11.443f, 0f)
                close()
            }
        }.build()

        return _Redo!!
    }

@Suppress("ObjectPropertyName")
private var _Redo: ImageVector? = null