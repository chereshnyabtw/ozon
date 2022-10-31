package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateProduct(
	val attributes: ArrayList<Attribute<Any>>,
	val barcode: String = "",
	@get:JsonProperty("category_id") val categoryId: Int,
	@get:JsonProperty("color_image") val colorImage: String = "",
	@get:JsonProperty("complex_attributes") val complexAttributes: ArrayList<Attribute<Any>> = arrayListOf(),
	@get:JsonProperty("currency_code") val currencyCode: String = "",
	val depth: Int,
	@get:JsonProperty("dimension_unit") val dimensionUnit: String,
	@get:JsonProperty("geo_names") val geoNames: ArrayList<String> = arrayListOf(),
	val height: Int,
	val images: ArrayList<String>,
	@get:JsonProperty("primary_image") val primaryImage: String = "",
	@get:JsonProperty("service_type") val serviceType: String = "IS_CODE_SERVICE",
	val images360: ArrayList<String> = arrayListOf(),
	val name: String,
	@get:JsonProperty("offer_id") val offerId: String,
	@get:JsonProperty("old_price") val oldPrice: String,
	@get:JsonProperty("pdf_list") val pdfList: ArrayList<PDFFile> = arrayListOf(),
	val price: String,
	val vat: String,
	val weight: Int,
	@get:JsonProperty("weight_unit") val weightUnit: String,
	val width: Int
) {
	data class CreateProductResponse(
		@get:JsonProperty("task_id") val taskId: Int = 0
	)
}
