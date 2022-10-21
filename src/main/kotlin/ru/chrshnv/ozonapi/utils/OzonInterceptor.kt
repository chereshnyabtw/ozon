package ru.chrshnv.ozonapi.utils

import org.springframework.http.HttpRequest
import org.springframework.http.MediaType
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import ru.chrshnv.ozonapi.config.Settings

class OzonInterceptor: ClientHttpRequestInterceptor {
	override fun intercept(
		request: HttpRequest,
		body: ByteArray,
		execution: ClientHttpRequestExecution
	): ClientHttpResponse {
		request.headers.contentType = MediaType.APPLICATION_JSON
		request.headers.add("Api-Key", Settings.getInstance().accessToken)
		request.headers.add("Client-Id", Settings.getInstance().clientId)

		return execution.execute(request, body)
	}
}
