package ru.chrshnv.ozonapi

import ru.chrshnv.ozonapi.config.Settings
import ru.chrshnv.ozonapi.services.AnalyticsService
import ru.chrshnv.ozonapi.services.ChatsService
import ru.chrshnv.ozonapi.services.ProductService
import ru.chrshnv.ozonapi.services.StocksService

class OzonClient(private val clientId: String, private val accessToken: String, private val analyticsService: AnalyticsService = AnalyticsService(), private val stocksService: StocksService = StocksService(), private val chatsService: ChatsService = ChatsService(), private val productService: ProductService = ProductService()) {
	fun getAnalyticsService(): AnalyticsService = analyticsService

	fun getStocksService(): StocksService = stocksService

	fun getChatsService(): ChatsService = chatsService

	fun getProductsService(): ProductService = productService

	fun setup() {
		Settings.getInstance().clientId = clientId
		Settings.getInstance().accessToken = accessToken
	}
}
