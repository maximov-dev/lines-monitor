package com.yarmaximov.linesmonitor.projects.models

import jakarta.annotation.Nonnull
import java.time.LocalDateTime
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.hibernate.validator.constraints.Length
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "projects")
data class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @field:NotNull
    @field:NotBlank
    val name: String?,

    @field:Length(min = 5, max = 1000)
    val description: String?,

    val createdAt: Instant = Instant.now(),
)