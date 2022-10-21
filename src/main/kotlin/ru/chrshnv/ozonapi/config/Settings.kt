package ru.chrshnv.ozonapi.config

class Settings {
	var clientId: String = ""
	var accessToken: String = ""

	companion object {
		private var sInstance: Settings? = null

		fun getInstance(): Settings {
			if(sInstance == null)
				sInstance = Settings()

			return sInstance ?: throw IllegalStateException("")
		}
	}
}
