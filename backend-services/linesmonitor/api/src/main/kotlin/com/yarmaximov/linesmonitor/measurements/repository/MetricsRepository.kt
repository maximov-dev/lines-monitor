package com.yarmaximov.linesmonitor.measurements.repository

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import com.yarmaximov.linesmonitor.measurements.model.Metric
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Instant
import java.util.*

interface MetricsRepository : JpaRepository<Metric, UUID>