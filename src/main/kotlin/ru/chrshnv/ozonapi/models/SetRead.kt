package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SetRead(
	@get:JsonProperty("chat_id")
	val chatID: String,

	@get:JsonProperty("from_message_id")
	val fromMessageID: String
)
