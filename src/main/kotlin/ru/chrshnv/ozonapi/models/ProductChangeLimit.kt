package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductChangeLimit(
	val remaining: Int = 0,
	@get:JsonProperty("reset_at") val resetAt: String = "",
	val value: Int = 0
)
