package com.example.jobfinder.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.JobVacancy
import com.example.domain.use_case.GetAllVacanciesUseCase
import com.example.domain.use_case.GetFavoriteVacanciesUseCase

class VacanciesViewModel(
    getAllVacanciesUseCase: GetAllVacanciesUseCase,
    getFavoriteVacanciesUseCase: GetFavoriteVacanciesUseCase
) : ViewModel() {

    val vacancies: LiveData<List<JobVacancy>> = getAllVacanciesUseCase.execute()

    val vacanciesFavorite: LiveData<List<JobVacancy>> = getFavoriteVacanciesUseCase.execute()

}