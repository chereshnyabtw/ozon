package ru.chrshnv.ozonapi.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import ru.chrshnv.ozonapi.config.RestTemplateConfig
import ru.chrshnv.ozonapi.models.GetChatList
import ru.chrshnv.ozonapi.models.Result
import ru.chrshnv.ozonapi.models.SendMessage
import ru.chrshnv.ozonapi.models.SetRead
import ru.chrshnv.ozonapi.models.UpdateChat

class ChatsService {
	fun getChats(chatList: GetChatList): ResponseEntity<GetChatList.GetChatListResponse> {
		val restTemplate = RestTemplateConfig.getRestTemplate()
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(chatList)

		return restTemplate
			.postForEntity("https://api-seller.ozon.ru/v2/chat/list", HttpEntity(json), GetChatList.GetChatListResponse::class.java)
	}

	fun updateChat(updateChat: UpdateChat): ResponseEntity<Result<ArrayList<UpdateChat.Message>>> {
		val restTemplate = RestTemplateConfig.getRestTemplate()
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(updateChat)

		return restTemplate
			.exchange(
				"https://api-seller.ozon.ru/v1/chat/updates",
				HttpMethod.POST,
				HttpEntity(json),
				object : ParameterizedTypeReference<Result<ArrayList<UpdateChat.Message>>> () {}
			)
	}

	fun setRead(read: SetRead): ResponseEntity<String> {
		val restTemplate = RestTemplateConfig.getRestTemplate()
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(read)

		return restTemplate
			.postForEntity("https://api-seller.ozon.ru/v2/chat/read", HttpEntity(json), String::class.java)
	}

	fun send(message: SendMessage): ResponseEntity<String> {
		val restTemplate = RestTemplateConfig.getRestTemplate()
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(message)

		return restTemplate
			.postForEntity("https://api-seller.ozon.ru/v1/chat/send/message", HttpEntity(json), String::class.java)
	}
}
