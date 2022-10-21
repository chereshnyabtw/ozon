package ru.chrshnv.ozonapi

import ru.chrshnv.ozonapi.config.Settings

class OzonClient(private val clientId: String, private val accessToken: String) {
	fun setup() {
		Settings.getInstance().clientId = clientId
		Settings.getInstance().accessToken = accessToken
	}
}
