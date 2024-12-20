package com.hyphen0.composeui.hotelbooking.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * UI Component for Information
 * */
@Composable
fun InfoUI(
    text: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(Color.Gray.copy(alpha = 0.3f))
            .padding(8.dp)
    ) {
        icon()
        Text(
            text = text,
            fontSize = 13.sp
        )
    }
}
