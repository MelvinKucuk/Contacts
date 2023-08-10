package com.melvin.contacts.core.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.contacts.core.domain.FileReader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fileReader: FileReader,
): ViewModel() {

    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            fileReader.readFileAndCreateDB()
            state = state.copy(isLoading = false)
        }
    }
}

data class MainState(
    val isLoading: Boolean = true
)