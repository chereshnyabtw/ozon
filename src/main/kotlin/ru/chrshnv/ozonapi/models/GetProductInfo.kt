package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class GetProductInfo(
	val sku: String = ""
) {
	data class GetProductInfoResponse(
		@get:JsonProperty("offer_id") val offerId: String = ""
	)
}
