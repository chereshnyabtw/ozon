package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class DictionaryValue (
	@get:JsonProperty("attribute_id") val attributeId: Int,
	@get:JsonProperty("category_id") val categoryId: Int,
	val language: String = "DEFAULT",
	@get:JsonProperty("last_value_id") val lastValueId: Int = 0,
	val limit: Int = 5000
) {
	data class DictionaryValueResponse(
		@get:JsonProperty("has_next") val hasNext: Boolean = false,
		val result: ArrayList<DictionaryValueResponseValues> = arrayListOf()
	)

	data class DictionaryValueResponseValues(
		val id: Int = 0,
		val info: String = "",
		val picture: String = "",
		val value: String = ""
	)
}
