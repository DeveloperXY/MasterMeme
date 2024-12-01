package com.developerxy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.developerxy.ui.R

val Manrope = FontFamily(
    Font(
        resId = R.font.manrope_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.manrope_extra_light,
        weight = FontWeight.ExtraLight,
    ),
    Font(
        resId = R.font.manrope_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.manrope_extra_bold,
        weight = FontWeight.ExtraBold,
    ),
    Font(
        resId = R.font.manrope_light,
        weight = FontWeight.Light,
    ),
    Font(
        resId = R.font.manrope_medium,
        weight = FontWeight.Medium,
    ),
    Font(
        resId = R.font.manrope_semi_bold,
        weight = FontWeight.SemiBold,
    ),
)

val AppTypography = Typography(
    bodySmall = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
    ),
    headlineMedium = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 28.sp
    ),
)