package com.example.domain.repository

import androidx.lifecycle.LiveData
import com.example.domain.model.Vacancy

interface VacanciesRepository {

        // Получение списка всех вакансий
        fun getAllVacancies(): LiveData<List<Vacancy>>

        // Получение вакансии по ID
        fun getVacancyById(id: String): LiveData<Vacancy?>

        // Добавление вакансии в избранное
        suspend fun addToFavorites(vacancy: Vacancy)

        // Удаление вакансии из избранного
        suspend fun removeFromFavorites(vacancyId: String)

        // Получение списка избранных вакансий
        fun getFavoriteVacancies(): LiveData<List<Vacancy>>

        // Поиск вакансий по ключевым словам
        fun searchVacancies(query: String): LiveData<List<Vacancy>>

        // Обновление информации о вакансии
        suspend fun updateVacancy(vacancy: Vacancy)

        // Удаление вакансии
        suspend fun deleteVacancy(vacancyId: String)
}