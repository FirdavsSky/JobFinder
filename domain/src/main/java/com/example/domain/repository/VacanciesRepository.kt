package com.example.domain.repository

import androidx.lifecycle.LiveData
import com.example.domain.model.JobVacancy

interface VacanciesRepository {

        // Получение списка всех вакансий
        fun getAllVacancies(): LiveData<List<JobVacancy>>

        // Получение вакансии по ID
        fun getVacancyById(id: String): LiveData<JobVacancy?>

        // Добавление вакансии в избранное
        suspend fun addToFavorites(jobVacancy: JobVacancy)

        // Удаление вакансии из избранного
        suspend fun removeFromFavorites(vacancyId: String)

        // Получение списка избранных вакансий
        fun getFavoriteVacancies(): LiveData<List<JobVacancy>>

        // Поиск вакансий по ключевым словам
        fun searchVacancies(query: String): LiveData<List<JobVacancy>>

        // Обновление информации о вакансии
        suspend fun updateVacancy(jobVacancy: JobVacancy)

        // Удаление вакансии
        suspend fun deleteVacancy(vacancyId: String)
}