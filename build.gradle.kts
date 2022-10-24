plugins {
    kotlin("jvm") version "1.7.20"
	id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
	implementation("org.springframework:spring-web:5.3.23")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4.2")
	implementation("com.fasterxml.jackson.core:jackson-core:2.13.4")
	implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.4")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
	testImplementation(kotlin("test"))
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = "com.github.chereshnyabtw"
			artifactId = "ozon"
			version = "1.1.0"

			from(components["kotlin"])
		}
	}
}
