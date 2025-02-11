package com.yarmaximov.linesmonitor.measurements.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.springframework.data.mongodb.core.mapping.Document
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.Instant
import java.util.*

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
)
@JsonSubTypes(
    JsonSubTypes.Type(CoreWebVitalsPayload::class, name = "CoreWebVitalsPayload"),
)
open class Payload

interface Measurements {
    val id: UUID?
    val measuredAt: Instant?
    val createdAt: Instant
    val payload: Payload?
}

data class CoreWebVitalsPayload(
    val largestContentfulPaint: Long,
    val firstInputDelay: Long,
    val cumulativeLayoutShift: Long,
) : Payload()

@Document(collection = "measurements")
data class Measurement(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    override val id: UUID?,

    override val payload: Payload?,

    @field:NotNull
    override val measuredAt: Instant?,

    override val createdAt: Instant = Instant.now(),
) : Measurements