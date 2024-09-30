package com.example.domain.use_case

import androidx.lifecycle.LiveData
import com.example.domain.repository.VacanciesRepository
import com.example.domain.model.JobVacancy

class GetFavoriteVacanciesUseCase(private val vacanciesRepository: VacanciesRepository) {
    fun execute(): LiveData<List<JobVacancy>> {
        return vacanciesRepository.getFavoriteVacancies()
    }
}