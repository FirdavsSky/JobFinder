package com.example.jobfinder.di

import com.example.data.remote.RetrofitInstance
import com.example.data.remote.VacanciesRepositoryImpl
import com.example.domain.repository.VacanciesRepository
import com.example.jobfinder.viewModel.VacanciesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { RetrofitInstance.api }

    // Определяем репозиторий
    single<VacanciesRepository> { VacanciesRepositoryImpl() }

    // Определяем ViewModel
    viewModel { VacanciesViewModel(get()) }
}