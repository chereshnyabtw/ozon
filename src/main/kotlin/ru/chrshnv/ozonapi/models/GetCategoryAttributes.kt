package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class GetCategoryAttributes(
	@get:JsonProperty("attribute_type") val attributeType: String = "ALL",
	@get:JsonProperty("category_id") val categoryId: ArrayList<Int>,
	val language: String = "DEFAULT"
) {
	data class GetCategoryAttributesResponse(
		@get:JsonProperty("category_id") val categoryId: Int = 0,
		val attributes: ArrayList<Attribute.AttributeInResponse> = arrayListOf()
	)
}
