package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

data class Attribute<T>(
	@get:JsonProperty("complex_id")
	val complexId: Int = 0,

	val id: Int = 0,

	val values: ArrayList<AttributeValue<T>> = arrayListOf()
) {
	data class AttributeValue<T>(
		@JsonInclude(JsonInclude.Include.NON_NULL)
		val dictionaryValueId: Int? = null,

		val value: T? = null
	)
}
