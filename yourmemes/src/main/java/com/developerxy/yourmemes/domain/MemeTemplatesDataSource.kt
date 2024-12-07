package com.developerxy.yourmemes.domain

import com.developerxy.yourmemes.domain.model.MemeTemplate

interface MemeTemplatesDataSource {
    fun getAllMemeTemplates(): List<MemeTemplate>
}