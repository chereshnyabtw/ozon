package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class TurnoverRequest(
	@get:JsonProperty("date_from")
	val dateFrom: String = ""
)
