package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class TurnoverResponse(
	val date: String = "",
	val period: String = "",
	@get:JsonProperty("commission_total") val commissionTotal: Double = 0.0,
	val categories: List<TurnoverItemCategory> = arrayListOf()
) {
	data class TurnoverItemCategory(
		@get:JsonProperty("turnover_items") val turnoverItems: List<TurnoverItem> = arrayListOf()
	) {
		data class TurnoverItem (
			val name: String = "",
			@get:JsonProperty("offer_id") val offerID: String = "",
			val recommendation: String = "",
			@get:JsonProperty("stock_items_total") val stockItemsTotal: Int = 0,
			val discounted: Boolean = false
		)
	}
}
