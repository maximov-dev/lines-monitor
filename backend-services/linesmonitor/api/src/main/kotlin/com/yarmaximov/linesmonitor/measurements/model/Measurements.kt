package com.yarmaximov.linesmonitor.measurements.model

import com.yarmaximov.linesmonitor.projects.models.Project
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.Instant
import java.util.*

@Entity
@Table(name = "environments")
data class Environment(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    val deviceType: String? = null,       // "Desktop", "Mobile"
    val operatingSystem: String? = null,  // "Windows 11", "macOS 13"
    val browserName: String? = null,      // "Chrome", "Firefox"
    val browserVersion: String? = null,
    val location: String? = null,         // "US-East", "EU-Central"

    @Column(nullable = false)
    val createdAt: UUID = UUID.randomUUID(),
)

@Entity
@Table(name = "test_configuration")
data class TestConfiguration(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    val name: String,

    val networkSettings: String? = null,
    val cpuThrottling: String? = null,
    val viewportWidth: Int? = null,
    val viewportHeight: Int? = null,

    @field:NotNull
    val createdAt: UUID = UUID.randomUUID(),
)

@Entity
@Table(name = "pages")
data class Page(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @field:NotNull
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    val projectId: Project,

    @field:NotNull
    val pagePath: String,

    val pageDescription: String? = null,

    @field:NotNull
    val createdAt: Instant = Instant.now()
)

@Entity
@Table(name = "session")
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    @field:NotNull
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    val project: Project,

    @ManyToOne
    @field:NotNull
    @JoinColumn(name = "environmentId", referencedColumnName = "id")
    val environment: Environment,

    @ManyToOne
    @JoinColumn(name = "testConfigId", referencedColumnName = "id")
    val testConfig: TestConfiguration,
)

@Entity
@Table(name = "metrics")
data class Metric(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,

    @field:NotNull
    val name: String = "",

    val unit: String = "",
)

@Entity
@Table(name = "measurements")
data class Measurement(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,

//    @ManyToOne
//    @field:NotNull
//    @JoinColumn(name = "sessionId", referencedColumnName = "id")
//    val session: Session,

//    @ManyToOne
//    @field:NotNull
//    @JoinColumn(name = "pageId", referencedColumnName = "id")
//    val page: Page,

//    @ManyToOne
//    @field:NotNull
//    @JoinColumn(name = "metricId", referencedColumnName = "id")
    /**
     * Save beforehand in DB to associate to each measurement
     */
    val metricId: UUID,

    val value: Double?,

    @field:NotNull
    val measuredAt: Instant?,

    val createdAt: Instant = Instant.now()
)