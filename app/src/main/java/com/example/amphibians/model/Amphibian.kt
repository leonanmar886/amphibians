package com.example.amphibians.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Amphibian (
  val name: String,
  val description: String,
  val type: String,
  @SerialName("img_src")
  val image: String
)