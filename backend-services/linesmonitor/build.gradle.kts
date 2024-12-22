plugins {
	kotlin("jvm") version "1.9.25"
}

group = "com.yarmaximov"
version = "1.0.0"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

subprojects {
	apply(plugin = "kotlin")
}

repositories {
	mavenCentral()
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
