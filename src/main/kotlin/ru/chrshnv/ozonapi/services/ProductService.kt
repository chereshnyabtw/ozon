package ru.chrshnv.ozonapi.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import ru.chrshnv.ozonapi.config.RestTemplateConfig
import ru.chrshnv.ozonapi.models.CreateProduct
import ru.chrshnv.ozonapi.models.Result

class ProductService {
	fun create(product: CreateProduct): ResponseEntity<Result<CreateProduct.CreateProductResponse>> {
		val restTemplate = RestTemplateConfig.getRestTemplate()
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(product)
		val tr = object : ParameterizedTypeReference<Result<CreateProduct.CreateProductResponse>>() {}

		return restTemplate
			.exchange(
				"https://api-seller.ozon.ru/v2/product/import",
				HttpMethod.POST,
				HttpEntity(json),
				tr
			)
	}
}
