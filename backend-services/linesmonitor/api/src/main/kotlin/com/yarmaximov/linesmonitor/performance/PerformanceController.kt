package com.yarmaximov.linesmonitor.performance

import com.yarmaximov.linesmonitor.measurements.model.CoreWebVitalsPayload
import com.yarmaximov.linesmonitor.performance.models.Analyze
import com.yarmaximov.linesmonitor.performance.service.PerformanceService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/performance")
class PerformanceController(val performanceService: PerformanceService) {

    @PostMapping("/analyze")
    fun analyze(@Valid @RequestBody(required = true) body: Analyze.Request): Analyze.Response<CoreWebVitalsPayload> {
        return performanceService.analyze(body)
    }
}