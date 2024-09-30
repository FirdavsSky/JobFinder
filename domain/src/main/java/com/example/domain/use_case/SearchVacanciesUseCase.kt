package com.example.domain.use_case

import androidx.lifecycle.LiveData
import com.example.domain.repository.VacanciesRepository
import com.example.domain.model.JobVacancy

class SearchVacanciesUseCase(private val vacanciesRepository: VacanciesRepository) {
    fun execute(query: String): LiveData<List<JobVacancy>> {
        return vacanciesRepository.searchVacancies(query)
    }
}