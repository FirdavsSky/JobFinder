package com.example.domain.use_case

import androidx.lifecycle.LiveData
import com.example.domain.repository.VacanciesRepository
import com.example.domain.model.Vacancy

class GetAllVacanciesUseCase(private val vacanciesRepository: VacanciesRepository) {
    fun execute(): LiveData<List<Vacancy>> {
        return vacanciesRepository.getAllVacancies()
    }
}