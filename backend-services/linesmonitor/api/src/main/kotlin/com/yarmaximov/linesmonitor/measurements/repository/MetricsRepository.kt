package com.yarmaximov.linesmonitor.measurements.repository

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Instant
import java.util.*

interface MeasurementsRepository : JpaRepository<Measurement, UUID>