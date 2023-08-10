package com.melvin.contacts.detail.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.melvin.contacts.R
import com.melvin.contacts.detail.presentation.viewmodel.ContactDetailEvent
import com.melvin.contacts.detail.presentation.viewmodel.ContactDetailState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailScreen(
    state: ContactDetailState,
    onEvent: (ContactDetailEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(ContactDetailEvent.SaveButtonClicked)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = stringResource(R.string.save)
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = stringResource(R.string.first_name))
            TextField(
                value = state.firstNameText,
                onValueChange = {
                    onEvent(ContactDetailEvent.FirstNameTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.last_name))
            TextField(
                value = state.lastNameText,
                onValueChange = {
                    onEvent(ContactDetailEvent.LastNameTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.company_name))
            TextField(
                value = state.companyNameText,
                onValueChange = {
                    onEvent(ContactDetailEvent.CompanyNameTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.address))
            TextField(
                value = state.addressText,
                onValueChange = {
                    onEvent(ContactDetailEvent.AddressTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.city))
            TextField(
                value = state.cityText,
                onValueChange = {
                    onEvent(ContactDetailEvent.CityTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.county))
            TextField(
                value = state.countyText,
                onValueChange = {
                    onEvent(ContactDetailEvent.CountyTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.state))
            TextField(
                value = state.stateText,
                onValueChange = {
                    onEvent(ContactDetailEvent.StateTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.zip))
            TextField(
                value = state.zipText,
                onValueChange = {
                    onEvent(ContactDetailEvent.ZipTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.phone))
            TextField(
                value = state.phoneText,
                onValueChange = {
                    onEvent(ContactDetailEvent.PhoneTextChanged(it))
                },
            )
            Text(text = stringResource(R.string.alt_phone))
            TextField(
                value = state.phone1Text,
                onValueChange = {
                    onEvent(ContactDetailEvent.Phone1TextChanged(it))
                },
            )
            Text(text = stringResource(R.string.email))
            TextField(
                value = state.emailText,
                onValueChange = {
                    onEvent(ContactDetailEvent.EmailTextChanged(it))
                },
            )
        }
    }
}

@Preview
@Composable
fun ContactDetailScreenPreview() {
    ContactDetailScreen(ContactDetailState()) {}
}