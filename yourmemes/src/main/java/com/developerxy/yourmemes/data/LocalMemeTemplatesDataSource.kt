package com.developerxy.yourmemes.data

import android.content.Context
import android.content.res.Resources
import android.net.Uri
import androidx.annotation.DrawableRes
import com.developerxy.yourmemes.domain.MemeTemplatesDataSource
import com.developerxy.yourmemes.domain.model.MemeTemplate

class LocalMemeTemplatesDataSource(
    private val context: Context
) : MemeTemplatesDataSource {
    override fun getAllMemeTemplates(): List<MemeTemplate> {
        return templates.mapIndexedNotNull { index, resId ->
            val name = context.toResourceEntryName(resId)
            name ?: return@mapIndexedNotNull null

            MemeTemplate(
                id = index,
                name = name,
                context.toResourceUri(resId).toString()
            )
        }
    }

    companion object {
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
    }
}

private fun Context.toResourceUri(@DrawableRes resId: Int): Uri {
    return Uri.parse("android.resource://${packageName}/$resId")
}

private fun Context.toResourceEntryName(@DrawableRes resId: Int): String? {
    return try {
        resources.getResourceEntryName(resId)
    } catch (e: Resources.NotFoundException) {
        null
    }
}