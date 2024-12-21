@file:OptIn(ExperimentalLayoutApi::class)

package com.hyphen0.composeui.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyphen0.composeui.ui.theme.ComposeUITheme

val notes = listOf(
    Note(
        "Project X",
        "This is a short description.",
        "Mar 5, 10:00"
    ),
    Note(
        "Project X",
        "This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description. This is a Long description.",
        "Mar 5, 10:00"
    )
)

/**
 * UI Container for Notes Screen
 * */
@Composable
fun NotesScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(notes) { note ->
            NoteUI(note = note)
        }
    }
}

@Composable
private fun NoteUI(
    note: Note,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFFA500))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = note.title,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = Color.White
            )
        }

        Text(
            text = note.description,
            color = Color.White,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 40.dp
                )
        )

        Text(
            text = note.timestamp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            textAlign = TextAlign.End
        )
    }
}

@Preview
@Composable
private fun Preview(modifier: Modifier = Modifier) {
    ComposeUITheme {
        NotesScreen()
    }
}

@Stable
data class Note(
    val title: String,
    val description: String,
    val timestamp: String
)
