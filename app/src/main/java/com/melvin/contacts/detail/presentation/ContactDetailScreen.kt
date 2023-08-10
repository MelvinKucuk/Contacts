package com.melvin.contacts.detail.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.melvin.contacts.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.first_name))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.last_name))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.company_name))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.address))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.city))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.country))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.state))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.zip))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.phone))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.alt_phone))
                }
            )
            TextField(
                value = "Name",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.email))
                }
            )
        }
    }
}

@Preview
@Composable
fun ContactDetailScreenPreview() {
    ContactDetailScreen()
}