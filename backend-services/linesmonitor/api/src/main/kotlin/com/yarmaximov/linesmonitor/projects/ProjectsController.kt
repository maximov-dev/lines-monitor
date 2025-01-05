package com.yarmaximov.linesmonitor.projects

import com.yarmaximov.linesmonitor.measurements.model.Metric
import com.yarmaximov.linesmonitor.projects.models.Project
import com.yarmaximov.linesmonitor.projects.service.ProjectsService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.*

@RestController
@RequestMapping("/api/v1/projects")
class ProjectsController(val projectsService: ProjectsService) {

    @PostMapping
    fun createProject(@Valid @RequestBody newProject: Project) {
        projectsService.create(newProject)
    }
}