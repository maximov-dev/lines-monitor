package com.yarmaximov.linesmonitor.measurements.service

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import com.yarmaximov.linesmonitor.measurements.repository.MeasurementsRepository
import com.yarmaximov.linesmonitor.measurements.repository.MetricsRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MeasurementsService(val measurementsRepository: MeasurementsRepository, val metricsRepository: MetricsRepository) {
    fun save(measurement: Measurement) {
//         metricsRepository.findByIdOrNull(measurement.metricId)
//            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Metric ID is incorrect")
//
//
//        measurementsRepository.save(measurement)
    }
}