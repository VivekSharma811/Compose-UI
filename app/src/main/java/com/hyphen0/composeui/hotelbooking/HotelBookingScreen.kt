@file:OptIn(ExperimentalLayoutApi::class)

package com.hyphen0.composeui.hotelbooking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import com.hyphen0.composeui.R
import com.hyphen0.composeui.hotelbooking.components.InfoUI
import com.hyphen0.composeui.hotelbooking.components.LabeledIcon
import com.hyphen0.composeui.ui.theme.ComposeUITheme

private val tags = listOf(
    "City Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deal",
    "Early Bird Discount",
    "Romantic Gateway",
    "24/7 Support",
)

private val offers = mapOf(
    R.drawable.bed to "2 Bed",
    R.drawable.breakfast to "Breakfast",
    R.drawable.cutlery to "Cutlery",
    R.drawable.pawprint to "Pet Friendly",
    R.drawable.serving_dish to "Dinner",
    R.drawable.snowflake to "Air Conditioning",
    R.drawable.television to "TV",
    R.drawable.wi_fi_icon to "Wifi",
)

/**
 * UI Container for Hotel Booking Screen
 * */
@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            HotelBanner()
        }
        item { HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp)) }
        item {
            Tags(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        item { HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp)) }
        item {
            Text(
                text = """
                    The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.’s best attractions.
                """.trimIndent(),
                fontSize = 13.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Justify
            )
        }
        item {
            Text(
                text = "What we offer",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                items(offers.entries.toList()) { (drawableResId, label) ->
                    InfoUI(
                        text =label,
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(drawableResId),
                                contentDescription = label,
                                modifier = Modifier.size(36.dp)
                            )
                        },
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
        item {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(
                        max = 400.dp
                    )
                    .fillMaxWidth()
            ) {
                Text(text = "Book now!")
            }
        }
    }
}

@Composable
private fun HotelBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.living_room),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 250.dp),
            contentScale = ContentScale.Crop
        )
        HotelBannerDescription(Modifier.fillMaxWidth())
    }
}

@Composable
private fun HotelBannerDescription(modifier: Modifier = Modifier) {
    val window = currentWindowAdaptiveInfo().windowSizeClass
    Row(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.7f))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Hotel California Strawberry",
                fontWeight = FontWeight.Bold,
                fontSize = when (window.windowWidthSizeClass) {
                    WindowWidthSizeClass.MEDIUM -> 24.sp
                    WindowWidthSizeClass.EXPANDED -> 34.sp
                    else -> 18.sp
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            LabeledIcon(
                text = "Los Angeles, California",
                icon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )
                }
            )
            LabeledIcon(
                text = "4.9 (13K reviews)",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                }
            )
        }
        Text(
            text = buildAnnotatedString {
                val fontSizeMultiplier = when (window.windowWidthSizeClass) {
                    WindowWidthSizeClass.MEDIUM -> 1.2f
                    WindowWidthSizeClass.EXPANDED -> 1.5f
                    else -> 1f
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp * fontSizeMultiplier
                    )
                ) {
                    append("420$/")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp * fontSizeMultiplier
                    )
                ) {
                    append("night")
                }
            }
        )
    }
}

@Composable
private fun Tags(modifier: Modifier = Modifier) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        tags.forEach { tag ->
            AssistChip(
                onClick = { },
                label = {
                    Text(text = tag)
                }
            )
        }
    }
}

@Preview(
    device = Devices.NEXUS_5
)
@Composable
private fun Preview(modifier: Modifier = Modifier) {
    ComposeUITheme {
        HotelBookingScreen()
    }
}

@Preview(
    device = Devices.NEXUS_10
)
@Composable
private fun TabletPreview(modifier: Modifier = Modifier) {
    ComposeUITheme {
        HotelBookingScreen()
    }
}
