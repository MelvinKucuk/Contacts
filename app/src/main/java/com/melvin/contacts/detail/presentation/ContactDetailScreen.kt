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
import com.melvin.contacts.detail.presentation.viewmodel.ContactDetailState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailScreen(
    state: ContactDetailState
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = state.firstNameText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.first_name))
                }
            )
            TextField(
                value = state.lastNameText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.last_name))
                }
            )
            TextField(
                value = state.companyNameText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.company_name))
                }
            )
            TextField(
                value = state.addressText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.address))
                }
            )
            TextField(
                value = state.cityText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.city))
                }
            )
            TextField(
                value = state.countyText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.county))
                }
            )
            TextField(
                value = state.stateText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.state))
                }
            )
            TextField(
                value = state.zipText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.zip))
                }
            )
            TextField(
                value = state.phoneText,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.phone))
                }
            )
            TextField(
                value = state.phone1Text,
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.alt_phone))
                }
            )
            TextField(
                value = state.emailText,
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
    ContactDetailScreen(ContactDetailState())
}