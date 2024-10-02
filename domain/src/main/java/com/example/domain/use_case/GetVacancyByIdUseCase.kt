package com.example.domain.use_case

import androidx.lifecycle.LiveData
import com.example.domain.repository.VacanciesRepository
import com.example.domain.model.JobVacancy

class GetVacancyByIdUseCase(private val vacanciesRepository: VacanciesRepository) {
    fun execute(id: String): LiveData<JobVacancy?> {
        return vacanciesRepository.getVacancyById(id)
    }
}