package com.harsh_san.website.components

import androidx.compose.runtime.Composable
import com.harsh_san.website.style.ButtonStyle
import com.harsh_san.website.style.SocialIconStyle
import com.harsh_san.website.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.opacity
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun LeftSide(
    colorMode: ColorMode,
    breakpoint: Breakpoint,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = if (breakpoint <= Breakpoint.SM)
            Alignment.CenterHorizontally else Alignment.Start
    ) {
        SpanText(
            text = Res.Strings.NAME,
            modifier = Modifier
                .margin(bottom = 12.px)
                .fontFamily(Res.Strings.ROBOTO_CONDENSED)
                .fontWeight(FontWeight.Bold)
                .fontSize(55.px)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .textAlign(
                    if (breakpoint <= Breakpoint.SM)
                        TextAlign.Center else TextAlign.Start
                )
        )

        SpanText(
            text = Res.Strings.PROFESSION,
            modifier = Modifier
                .margin(bottom = 24.px)
                .fontFamily(Res.Strings.ROBOTO_REGULAR)
                .fontWeight(FontWeight.Bold)
                .fontSize(18.px)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .textAlign(
                    if (breakpoint <= Breakpoint.SM)
                        TextAlign.Center else TextAlign.Start
                )
        )
        Surface(
            modifier = Modifier
                .height(4.px)
                .width(40.px)
                .margin(bottom = 24.px)
                .background(
                    if (colorMode.isLight) Res.Theme.BLUE.color else Res.Theme.LIGHT_BLUE.color
                )
                .align(
                    if (breakpoint <= Breakpoint.SM)
                        Alignment.CenterHorizontally else Alignment.Start
                )
        ) {}
        SpanText(
            text = Res.Strings.ABOUT_ME,
            modifier = Modifier
                .fontFamily(Res.Strings.ROBOTO_REGULAR)
                .fontSize(14.px)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .opacity(60.percent)
                .lineHeight(2)
                .margin(bottom = 60.px)
                .textAlign(
                    if (breakpoint <= Breakpoint.SM)
                        TextAlign.Center else TextAlign.Start
                )
        )
        Button(
            modifier = ButtonStyle.toModifier()
                .margin(bottom = 50.px),
            size = ButtonSize.LG,
            onClick = { window.location.href = Res.Strings.MY_EMAIL }
        ) {
            Image(
                modifier = Modifier.margin(right = 12.px),
                src = if (colorMode.isLight) Res.Icon.EMAIL_LIGHT else Res.Icon.EMAIL_DARK
            )
            SpanText(
                text = Res.Strings.BUTTON_TEXT,
                modifier = Modifier
                    .fontSize(14.px)
                    .color(if (colorMode.isLight) Colors.White else Colors.Black )
                    .fontFamily(Res.Strings.ROBOTO_REGULAR)
                    .fontWeight(FontWeight.Bold)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .gap(12.px),
            horizontalArrangement = if (breakpoint <= Breakpoint.SM)
                Arrangement.Center else Arrangement.Start
        ) {
            SocialIcons.entries.filter {
                if (colorMode.isLight) !it.name.contains("Light")
                else it.name.contains("Light")
            }.forEach {
                IconButton(
                    modifier = SocialIconStyle.toModifier(),
                    icon = it.icon,
                    link = it.link,
                    colorMode = colorMode
                )
            }
        }
    }
}