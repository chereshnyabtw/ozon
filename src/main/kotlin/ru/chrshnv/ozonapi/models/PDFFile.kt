package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class PDFFile(
	val index: Int,
	val name: String,
	@get:JsonProperty("src_url") val srcUrl: String
)
