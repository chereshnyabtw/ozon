package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class GetChatList(
	val filter: GetChatListFilter = GetChatListFilter(),
	val limit: Int = 30,
	var offset: Int = 0
) {
	data class GetChatListFilter(
		@get:JsonProperty("chat_status") val chatStatus: String = "Opened",
		@get:JsonProperty("unread_only") val unreadOnly: Boolean = true
	)

	data class GetChatListResponse(
		@get:JsonProperty("chats") val chats: ArrayList<Chat> = arrayListOf()
	) {
		data class Chat(
			@get:JsonProperty("chat_id") val chatID: String = "",
			@get:JsonProperty("chat_type") val chatType: String = "",
			@get:JsonProperty("created_at") val createdAt: String = "",
			@get:JsonProperty("first_unread_message_id") val firstUnreadMessageID: String = "0",
			@get:JsonProperty("last_message_id") val lastMessageID: String = "0",
			@get:JsonProperty("unread_count") val unreadCount: Int = 0
		)
	}
}
