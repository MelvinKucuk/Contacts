package com.melvin.contacts.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.melvin.contacts.home.presentation.components.ContactRow
import com.melvin.contacts.home.presentation.viewmodel.HomeEvent
import com.melvin.contacts.home.presentation.viewmodel.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.contacts) { contact ->
                ContactRow(contact = contact) {
                    onEvent(HomeEvent.ContactClicked(it))
                }
            }
        }
    }
}