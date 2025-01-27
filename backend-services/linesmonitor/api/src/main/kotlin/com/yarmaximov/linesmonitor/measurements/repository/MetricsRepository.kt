package com.yarmaximov.linesmonitor.measurements.repository

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import com.yarmaximov.linesmonitor.measurements.model.Metric
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
interface MetricsRepository : JpaRepository<Metric, UUID>