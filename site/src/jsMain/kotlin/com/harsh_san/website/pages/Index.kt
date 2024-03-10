package com.harsh_san.website.pages

import androidx.compose.runtime.*
import com.harsh_san.website.components.ThemeSwitchButtom
import com.harsh_san.website.components.profileCard
import com.harsh_san.website.util.Res
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage

@Page
@Composable
fun HomePage() {
    var colorMode by ColorMode.currentState

    LaunchedEffect(colorMode){
        val saveTheme = localStorage.getItem(Res.Strings.SAVED_THEME) ?: ColorMode.LIGHT.name
        colorMode = ColorMode.valueOf(saveTheme)
    }

    ThemeSwitchButtom(
        colorMode = colorMode,
        onClick = {
            colorMode = colorMode.opposite
            localStorage.setItem(Res.Strings.SAVED_THEME, colorMode.name)

        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundImage(
                linearGradient(
                    dir = LinearGradient.Direction.ToRight,
                    from = if (colorMode.isLight)
                        Res.Theme.GRADIENT_ONE.color else Res.Theme.GRADIENT_ONE_DARK.color,
                    to = if (colorMode.isLight)
                        Res.Theme.GRADIENT_TWO.color else Res.Theme.GRADIENT_TWO_DARK.color
                )
            )
        ,
        contentAlignment = Alignment.Center
    ) {
        profileCard(colorMode = colorMode)
    }
}
