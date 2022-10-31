package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SendMessage(
	@get:JsonProperty("chat_id") val chatID: String,
	val text: String
)
