package com.melvin.contacts.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.melvin.contacts.core.domain.Contact

@Composable
fun ContactRow(
    contact: Contact,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
) {
    Card(
        modifier = modifier
            .height(46.dp)
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(CardDefaults.elevatedShape)
            .clickable {
                onClick(contact.key)
            },
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        ),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            VisitorInitials(contact.initials)

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = contact.fullName,
                color = DarkGray,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactRowPreview() {
    ContactRow(
        Contact(
            firstName = "Melvin",
            lastName = "Kucuk",
            companyName = "Right Balance",
            address = "Fake Street 123",
            city = "Fake Street 123",
            county = "Argentina",
            state = "Buenos Aires",
            zip = "1333",
            phone = "11432343",
            phone1 = "112345678",
            email = "mkucuk@gmail.com",
        )
    ) {}
}