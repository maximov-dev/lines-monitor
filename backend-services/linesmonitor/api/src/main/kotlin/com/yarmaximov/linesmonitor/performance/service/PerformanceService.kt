package com.yarmaximov.linesmonitor.performance.service

import com.yarmaximov.linesmonitor.performance.models.Analyze
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.net.URISyntaxException
import org.apache.logging.log4j.LogManager;



@Service
class PerformanceService {
    val logger = LogManager.getLogger(PerformanceService::class.java)

    fun analyze(body: Analyze.Request): Analyze.Response {
        val desiredCapabilities = DesiredCapabilities()
        desiredCapabilities.setCapability("pageLoadStrategy", "normal")
        val options = ChromeOptions()

        options.addArguments("--headless")
        options.addArguments("--disable-gpu")
        options.merge(desiredCapabilities)

        val driver: ChromeDriver by lazy(LazyThreadSafetyMode.PUBLICATION) {
            ChromeDriver(options)
        }

        try {
            URI(body.url)

            driver.get(body.url)

            // Use JavaScript to fetch performance metrics
            val performanceTiming = (driver as JavascriptExecutor)
                .executeScript("return window.performance.timing") as Map<*, *>
            val navigationStart = performanceTiming["navigationStart"] as Long
            val domContentLoadedEventEnd = performanceTiming["domContentLoadedEventEnd"] as Long
            val loadEventEnd = performanceTiming["loadEventEnd"] as Long

            // Calculate metrics
            val renderTime = loadEventEnd - navigationStart
            val domContentLoadedTime = domContentLoadedEventEnd - navigationStart


//            val webVitalsScriptResult = (driver as JavascriptExecutor).executeScript(webVitalsScript) as Map<*, *>
//
//            val webVitals = WebVitals(
//                cumulativeLayoutShift = webVitalsScriptResult["cls"] as Double,
//                largestContentfulPaint = webVitalsScriptResult["lcp"] as Double,
//                firstInputDelay = webVitalsScriptResult["fid"] as Double,
//                timeToFirstByte = webVitalsScriptResult["ttfb"] as Double,
//            )


            return Analyze.Response(
                url = body.url,
                renderTime = renderTime,
                domContentLoadedTime = domContentLoadedTime,
                //webVitals = webVitals,
            )
        } catch (exception: URISyntaxException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect URL")
        } catch (exception: Exception) {
            logger.error("Error when analyzing a webapp ${exception.message}")
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong when analyzing a webpage")
        } finally {
            driver.quit()
        }
    }
}