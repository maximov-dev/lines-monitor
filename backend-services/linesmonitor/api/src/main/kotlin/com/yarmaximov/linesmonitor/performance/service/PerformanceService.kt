package com.yarmaximov.linesmonitor.performance.service

import com.yarmaximov.linesmonitor.measurements.model.CoreWebVitalsPayload
import com.yarmaximov.linesmonitor.performance.models.Analyze
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.net.URISyntaxException
import org.apache.logging.log4j.LogManager
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.performance.Performance
import org.openqa.selenium.devtools.v129.performance.model.Metric
import java.util.*


@Service
class PerformanceService {
    val logger = LogManager.getLogger(PerformanceService::class.java)

    fun analyze(body: Analyze.Request): Analyze.Response<CoreWebVitalsPayload> {
        val options = ChromeOptions()
        options.addArguments("--headless")
        options.addArguments("--disable-gpu")
        options.addArguments("--enable-logging")


        val driver = ChromeDriver(options)

        try {

            val devTools = driver.devTools
            devTools.createSession()

            devTools.send(Performance.enable(Optional.of(Performance.EnableTimeDomain.TIMETICKS)))
            val metrics: List<Metric> = devTools.send(Performance.getMetrics())
            URI(body.url)

            driver.get(body.url)

            val webVitals = mutableMapOf<String, Long>()

            for (metric in metrics) {
                when (metric.name) {
                    "LargestContentfulPaint" -> webVitals["largestContentfulPaint"] = metric.value as Long
                    "FirstInputDelay" -> webVitals["firstInputDelay"] = metric.value as Long
                    "CumulativeLayoutShift" -> webVitals["cumulativeLayoutShift"] = metric.value as Long
                }
            }


            return Analyze.Response(
                url = body.url,
                payload = CoreWebVitalsPayload(
                    largestContentfulPaint = webVitals["largestContentfulPaint"] ?: 0,
                    firstInputDelay = webVitals["firstInputDelay"] ?: 0,
                    cumulativeLayoutShift = webVitals["cumulativeLayoutShift"] ?: 0,
                )
            )
        } catch (exception: URISyntaxException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect URL")
        } catch (exception: Exception) {
            logger.error("Error when analyzing a webapp ${exception.message}")
            throw ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Something went wrong when analyzing a webpage"
            )
        } finally {
            driver.quit()
        }
    }
}