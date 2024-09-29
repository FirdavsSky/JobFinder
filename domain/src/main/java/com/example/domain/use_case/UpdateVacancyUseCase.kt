package com.example.domain.use_case

import com.example.domain.repository.VacanciesRepository
import com.example.domain.model.Vacancy

class UpdateVacancyUseCase(private val vacanciesRepository: VacanciesRepository) {
    suspend fun execute(vacancy: Vacancy) {
        vacanciesRepository.updateVacancy(vacancy)
    }
}