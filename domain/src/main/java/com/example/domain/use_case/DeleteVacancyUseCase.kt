package com.example.domain.use_case

import com.example.domain.repository.VacanciesRepository

class DeleteVacancyUseCase(private val vacanciesRepository: VacanciesRepository) {
    suspend fun execute(vacancyId: String) {
        vacanciesRepository.deleteVacancy(vacancyId)
    }
}