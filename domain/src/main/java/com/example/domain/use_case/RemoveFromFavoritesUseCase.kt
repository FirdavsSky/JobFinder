package com.example.domain.use_case

import com.example.domain.repository.VacanciesRepository

class RemoveFromFavoritesUseCase(private val vacanciesRepository: VacanciesRepository) {
    suspend fun execute(vacancyId: String) {
        vacanciesRepository.removeFromFavorites(vacancyId)
    }
}