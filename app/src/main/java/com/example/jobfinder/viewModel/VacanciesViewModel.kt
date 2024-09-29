package com.example.jobfinder.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Vacancy
import com.example.domain.repository.VacanciesRepository

class VacanciesViewModel(private val repository: VacanciesRepository) : ViewModel() {



    val vacancies: LiveData<List<Vacancy>> = repository.getAllVacancies()

    init {
        // Здесь вы можете вызвать getAllVacancies(), если это необходимо
        // Но у вас уже есть LiveData для отслеживания данных
    }
}