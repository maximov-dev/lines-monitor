plugins {
	kotlin("jvm") version "1.9.25"
	id("com.gradleup.shadow") version "8.3.5" apply false
}

version = "1.0.0"

allprojects {
	group = "com.yarmaximov"
}

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
