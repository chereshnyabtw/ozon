package ru.chrshnv.ozonapi.config

import org.springframework.web.client.RestTemplate
import ru.chrshnv.ozonapi.utils.OzonInterceptor

class RestTemplateConfig {
	companion object {
		fun getRestTemplate(): RestTemplate {
			val restTemplate = RestTemplate()
			restTemplate.interceptors.add(OzonInterceptor())
			return restTemplate
		}
	}
}
