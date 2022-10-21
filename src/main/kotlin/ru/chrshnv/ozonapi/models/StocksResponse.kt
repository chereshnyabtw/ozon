package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class StocksResponse (
	@get:JsonProperty("total_items")
	val totalItems: List<StockItem> = arrayListOf()
) {
	data class StockItem (
		@get:JsonProperty("offer_id")
		val offerID: String = "",
		val stock: Stock = Stock()
	) {
		data class Stock (
			@get:JsonProperty("for_sale")
			val forSale: Int = 0,
		)
	}

	data class StocksRequest(val limit: Int = 0, val offset: Int = 0)
}
