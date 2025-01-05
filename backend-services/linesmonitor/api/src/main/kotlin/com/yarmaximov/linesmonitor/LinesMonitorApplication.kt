package com.yarmaximov.linesmonitor

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@EnableAutoConfiguration
@ConfigurationPropertiesScan
@SpringBootApplication
class LinesMonitorApplication

fun main(args: Array<String>) {
	runApplication<LinesMonitorApplication>(*args)
}
