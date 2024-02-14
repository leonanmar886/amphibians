package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibiansApi

interface AmphibiansRepository {
  suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibiansRepository(
  private val amphibiansApi: AmphibiansApi
) : AmphibiansRepository {
  override suspend fun getAmphibians(): List<Amphibian> {
    return amphibiansApi.getAmphibians()
  }
}