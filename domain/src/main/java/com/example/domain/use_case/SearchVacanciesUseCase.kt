package com.example.domain.use_case

import androidx.lifecycle.LiveData
import com.example.domain.repository.VacanciesRepository
import com.example.domain.model.Vacancy

class SearchVacanciesUseCase(private val vacanciesRepository: VacanciesRepository) {
    fun execute(query: String): LiveData<List<Vacancy>> {
        return vacanciesRepository.searchVacancies(query)
    }
}