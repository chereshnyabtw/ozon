package ru.chrshnv.ozonapi.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import ru.chrshnv.ozonapi.config.RestTemplateConfig
import ru.chrshnv.ozonapi.models.GetProductInfo
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

	fun getProductInfo(sku: GetProductInfo): ResponseEntity<Result<GetProductInfo.GetProductInfoResponse>> {
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(sku)
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.exchange(
				"https://api-seller.ozon.ru/v2/product/info",
				HttpMethod.POST,
				HttpEntity(json),
				object : ParameterizedTypeReference<Result<GetProductInfo.GetProductInfoResponse>> () {}
			)
	}
}
