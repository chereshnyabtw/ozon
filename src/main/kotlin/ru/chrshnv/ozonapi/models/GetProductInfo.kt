package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class GetProductInfo(
	val sku: String = ""
) {
	data class GetProductInfoRoot(
		val result: Result = Result()
	) {
		data class Result(
			@get:JsonProperty("offer_id")
			val offerId: String = ""
		)
	}
}
