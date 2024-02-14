package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.model.Amphibian

sealed interface AmphibiansUiState {
  data class Success(val data: List<Amphibian>) : AmphibiansUiState
  data object Loading : AmphibiansUiState
  data object Error : AmphibiansUiState
}

class AmphibiansViewModel(private val repository: AmphibiansRepository): ViewModel() {
  var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
    private set
  
  init {
    getAmphibians()
  }
  
  fun getAmphibians() {
    viewModelScope.launch {
      amphibiansUiState = try {
        AmphibiansUiState.Success(repository.getAmphibians())
      } catch (e: Exception) {
        AmphibiansUiState.Error
      }
    }
  }
}