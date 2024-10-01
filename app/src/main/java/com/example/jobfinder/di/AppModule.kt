package com.example.jobfinder.di

import com.example.data.remote.VacanciesClient
import com.example.data.remote.VacanciesRepositoryImpl
import com.example.domain.repository.VacanciesRepository
import com.example.domain.use_case.GetAllVacanciesUseCase
import com.example.jobfinder.viewModel.VacanciesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { VacanciesClient.api }

    single<VacanciesRepository> { VacanciesRepositoryImpl() }

    single { GetAllVacanciesUseCase(get()) }

    viewModel { VacanciesViewModel(get()) }
}