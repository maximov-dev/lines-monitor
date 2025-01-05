package com.yarmaximov.linesmonitor.measurements.service

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import com.yarmaximov.linesmonitor.measurements.model.Metric
import com.yarmaximov.linesmonitor.measurements.repository.MeasurementsRepository
import com.yarmaximov.linesmonitor.measurements.repository.MetricsRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class MeasurementsService(val measurementsRepository: MeasurementsRepository) {
    fun save(measurement: Measurement) {
        measurementsRepository.save(measurement)
    }
}