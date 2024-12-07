package com.developerxy.yourmemes.ui.model

typealias DomainMemeTemplate = com.developerxy.yourmemes.domain.model.MemeTemplate

data class MemeTemplate(
    val id: Int,
    val name: String,
    val resourcePath: String
)

fun DomainMemeTemplate.toUiModel() = MemeTemplate(id, name, resourcePath)