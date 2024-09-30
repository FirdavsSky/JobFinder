package com.example.domain.use_case

import com.example.domain.repository.VacanciesRepository
import com.example.domain.model.JobVacancy

class UpdateVacancyUseCase(private val vacanciesRepository: VacanciesRepository) {
    suspend fun execute(jobVacancy: JobVacancy) {
        vacanciesRepository.updateVacancy(jobVacancy)
    }
}