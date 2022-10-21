package ru.chrshnv.ozonapi.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import ru.chrshnv.ozonapi.config.RestTemplateConfig
import ru.chrshnv.ozonapi.models.TurnoverRequest
import ru.chrshnv.ozonapi.models.TurnoverResponse
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date

class AnalyticsService {
	fun turnoverMetrics(date: Date): ResponseEntity<TurnoverResponse> {
		val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(TurnoverRequest(df.format(date)))
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.postForEntity(
				"https://api-seller.ozon.ru/v1/analytics/item_turnover",
				HttpEntity(json),
				TurnoverResponse::class.java
			)
	}
}
