package com.yarmaximov.linesmonitor.measurements.repository

import com.yarmaximov.linesmonitor.measurements.model.Measurement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
interface MeasurementsRepository : MongoRepository<Measurement, UUID>