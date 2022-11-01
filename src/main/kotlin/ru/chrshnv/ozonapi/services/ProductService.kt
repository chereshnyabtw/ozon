package ru.chrshnv.ozonapi.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import ru.chrshnv.ozonapi.config.RestTemplateConfig
import ru.chrshnv.ozonapi.models.*

class ProductService {
	fun create(product: CreateProduct): ResponseEntity<Result<CreateProduct.CreateProductResponse>> {
		val restTemplate = RestTemplateConfig.getRestTemplate()
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(product)

		return restTemplate
			.exchange(
				"https://api-seller.ozon.ru/v2/product/import",
				HttpMethod.POST,
				HttpEntity(json),
				object : ParameterizedTypeReference<Result<CreateProduct.CreateProductResponse>>() {}
			)
	}

	fun getAttributesForCategory(body: GetCategoryAttributes): ResponseEntity<List<Result<GetCategoryAttributes.GetCategoryAttributesResponse>>> {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.exchange(
				"https://api-seller.ozon.ru/v3/category/attribute",
				HttpMethod.POST,
				HttpEntity(jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(body)),
				object : ParameterizedTypeReference<List<Result<GetCategoryAttributes.GetCategoryAttributesResponse>>> () {}
			)
	}

	fun getDictionaryValues(body: DictionaryValue): ResponseEntity<DictionaryValue.DictionaryValueResponse> {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.exchange(
				"https://api-seller.ozon.ru/v2/category/attribute/values",
				HttpMethod.POST,
				HttpEntity(jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(body)),
				DictionaryValue.DictionaryValueResponse::class.java
			)
	}

	fun getProductChangeLimit(): ResponseEntity<Result<ProductChangeLimit>> {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.exchange(
				"https://api-seller.ozon.ru/v2/product/info/limit",
				HttpMethod.POST,
				HttpEntity.EMPTY,
				object : ParameterizedTypeReference<Result<ProductChangeLimit>> () {}
			)
	}
}
