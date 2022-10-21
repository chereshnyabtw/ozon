package ru.chrshnv.ozonapi.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import ru.chrshnv.ozonapi.config.RestTemplateConfig
import ru.chrshnv.ozonapi.models.StocksResponse

class StocksService {
	fun getStocks(body: StocksResponse.StocksRequest): ResponseEntity<StocksResponse> {
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(body)
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.postForEntity(
				"https://api-seller.ozon.ru/v1/analytics/stock_on_warehouses",
			HttpEntity(json),
			StocksResponse::class.java
			)
	}
}
