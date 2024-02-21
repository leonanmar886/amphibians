package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
  val amphibianRepository: AmphibiansRepository
}

class DefaultAppContainer : AppContainer {
  private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/amphibians"
  
  private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
  
  private val retrofitService: AmphibiansApi = retrofit.create(AmphibiansApi::class.java)
  
  override val amphibianRepository: AmphibiansRepository by lazy {
    NetworkAmphibiansRepository(retrofitService)
  }
}