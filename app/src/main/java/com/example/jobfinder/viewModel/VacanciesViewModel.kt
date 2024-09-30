package com.example.jobfinder.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.JobVacancy
import com.example.domain.repository.VacanciesRepository

class VacanciesViewModel(repository: VacanciesRepository) : ViewModel() {

    val vacancies: LiveData<List<JobVacancy>> = repository.getAllVacancies()

}