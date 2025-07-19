package com.swapcard.randomusers.users.presentation.detail.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.presentation.utils.DateTimeFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun BirthInformation(
    dob: String?, age: Int?,
    pattern: DateTimeFormat = DateTimeFormat.DD_MM_YYYY
) {
    val formattedDate = DateTimeFormatter.ofPattern(pattern.value)
        .format(ZonedDateTime.parse(dob))

    SectionRow(
        title = stringResource(R.string.date_of_birth),
        content = formattedDate
    )

    SectionRow(
        title = stringResource(R.string.age),
        content = "$age years"
    )
}