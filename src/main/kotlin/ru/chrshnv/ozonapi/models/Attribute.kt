package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

data class Attribute<T>(
	@get:JsonProperty("complex_id") val complexId: Int = 0,
	val id: Int = 0,
	val values: ArrayList<AttributeValue<T>> = arrayListOf()
) {
	data class AttributeValue<T>(
		@get:JsonInclude(JsonInclude.Include.NON_NULL) val dictionaryValueId: Int? = null,
		val value: T? = null
	)

	data class AttributeInResponse(
		val description: String = "",
		@get:JsonProperty("dictionary_id") val dictionaryId: Int = 0,
		@get:JsonProperty("group_id") val groupId: Int = 0,
		@get:JsonProperty("group_name") val groupName: String = "",
		val id: Int = 0,
		@get:JsonProperty("is_collection") val isCollection: Boolean = false,
		@get:JsonProperty("is_required") val isRequired: Boolean = false,
		val name: String = "",
		val type: String = ""
	)
}
