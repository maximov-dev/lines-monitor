package com.yarmaximov.linesmonitor

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableAutoConfiguration
@ConfigurationPropertiesScan("com.yarmaximov.linesmonitor.*")
@EnableJpaRepositories("com.yarmaximov.linesmonitor.*")
@EntityScan("com.yarmaximov.linesmonitor.*")
@ComponentScan("com.yarmaximov.linesmonitor.*")
class LinesMonitorApplication

fun main(args: Array<String>) {
	runApplication<LinesMonitorApplication>(*args)
}
