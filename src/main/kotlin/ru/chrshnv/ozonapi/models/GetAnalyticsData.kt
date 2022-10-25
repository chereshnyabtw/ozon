package ru.chrshnv.ozonapi.models

import com.fasterxml.jackson.annotation.JsonProperty

data class GetAnalyticsData(
	@JsonProperty("date_from")
	val dateFrom: String = "",

	@JsonProperty("date_to")
	val dateTo: String = "",

	val dimension: ArrayList<String> = arrayListOf(),
	val metrics: ArrayList<String> = arrayListOf(),
	val limit:String = "1000"
) {
	data class GetAnalyticsDataRoot(
		val result: Result = Result()
	) {
		data class Result(
			val data: ArrayList<Data> = arrayListOf(),
			val totals: ArrayList<Int> = arrayListOf()
		) {
			data class Data(
				val dimensions: ArrayList<Dimension> = arrayListOf(),
				val metrics: ArrayList<Int> = arrayListOf()
			) {
				data class Dimension(
					val id: String = "",
					val name: String = ""
				)
			}
		}
	}
}
