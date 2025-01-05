package com.yarmaximov.linesmonitor.projects.service

import com.yarmaximov.linesmonitor.projects.models.Project
import com.yarmaximov.linesmonitor.projects.repository.ProjectsRepository
import org.springframework.stereotype.Service

@Service
class ProjectsService(val projectsRepository: ProjectsRepository) {
    fun create(project: Project) {
        projectsRepository.save(project)
    }
}