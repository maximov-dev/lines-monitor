package com.yarmaximov.linesmonitor.projects.repository

import com.yarmaximov.linesmonitor.projects.models.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProjectsRepository : JpaRepository<Project, UUID>