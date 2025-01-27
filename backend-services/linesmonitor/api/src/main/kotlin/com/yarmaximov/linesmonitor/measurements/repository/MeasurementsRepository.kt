package com.yarmaximov.linesmonitor.measurements.repository

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
interface MeasurementsRepository : JpaRepository<Measurement, UUID>