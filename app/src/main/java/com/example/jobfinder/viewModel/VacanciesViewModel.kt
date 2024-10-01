package com.example.jobfinder.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.JobVacancy
import com.example.domain.use_case.GetAllVacanciesUseCase

class VacanciesViewModel(private val getAllVacanciesUseCase: GetAllVacanciesUseCase) : ViewModel() {

    val vacancies: LiveData<List<JobVacancy>> = getAllVacanciesUseCase.execute()

}