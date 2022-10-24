package ru.chrshnv.ozonapi

import ru.chrshnv.ozonapi.config.Settings
import ru.chrshnv.ozonapi.services.AnalyticsService
import ru.chrshnv.ozonapi.services.ChatsService
import ru.chrshnv.ozonapi.services.StocksService

class OzonClient(private val clientId: String, private val accessToken: String, private val analyticsService: AnalyticsService = AnalyticsService(), private val stocksService: StocksService = StocksService(), private val chatsService: ChatsService = ChatsService()) {
	fun getAnalyticsService(): AnalyticsService {
		return analyticsService
	}

	fun getStocksService(): StocksService {
		return stocksService
	}

	fun getChatsService(): ChatsService {
		return chatsService
	}

	fun setup() {
		Settings.getInstance().clientId = clientId
		Settings.getInstance().accessToken = accessToken
	}
}
