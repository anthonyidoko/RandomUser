package com.swapcard.randomusers.users.presentation.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SectionInfo(
    modifier: Modifier = Modifier,
    headerTitle: String,
    content: @Composable () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = headerTitle,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(2.dp))

        content()
    }

}