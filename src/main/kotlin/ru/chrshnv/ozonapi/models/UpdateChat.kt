package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateChat(
	@get:JsonProperty("chat_id")
	val chatID: String,

	@get:JsonProperty("from_message_id")
	val fromMessageID: String = "0",

	val limit: Int = 0
) {
	data class UpdateChatResponse(
		val result: ArrayList<Result> = arrayListOf()
	) {
		data class Result (
			val text: String = "",
			val id: String = ""
		)
	}
}
