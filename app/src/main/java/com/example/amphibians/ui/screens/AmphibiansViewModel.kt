package com.example.amphibians.ui.screens

sealed interface AmphibiansViewModel {
  data class Success(val data: List<Amphibian>) : AmphibiansViewModel
  data object Loading : AmphibiansViewModel
  data object Error : AmphibiansViewModel
}