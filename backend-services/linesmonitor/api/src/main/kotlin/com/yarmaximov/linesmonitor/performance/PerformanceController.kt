package com.yarmaximov.linesmonitor.performance

import com.yarmaximov.linesmonitor.measurements.model.Metric
import com.yarmaximov.linesmonitor.performance.models.Analyze
import com.yarmaximov.linesmonitor.performance.service.PerformanceService
import com.yarmaximov.linesmonitor.projects.models.Project
import com.yarmaximov.linesmonitor.projects.service.ProjectsService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController
@RequestMapping("/api/v1/performance")
class PerformanceController(val performanceService: PerformanceService) {

    @GetMapping("/analyze")
    fun analyze(@RequestParam(required = true) url: String): Analyze.Response {
        return performanceService.analyze(url)
    }
}