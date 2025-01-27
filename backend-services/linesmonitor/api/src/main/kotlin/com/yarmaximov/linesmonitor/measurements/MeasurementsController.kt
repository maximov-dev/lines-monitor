package com.yarmaximov.linesmonitor.measurements

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import com.yarmaximov.linesmonitor.measurements.service.MeasurementsService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/measurements")
class MeasurementsController(val measurementsService: MeasurementsService) {

    @PostMapping
    fun saveMeasurement(@Valid @RequestBody(required = true) body: Measurement) {
        measurementsService.save(body)
    }
}