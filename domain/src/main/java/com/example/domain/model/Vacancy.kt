package com.example.domain.model

data class Vacancy(
    val id: String, // Идентификатор
    val title: String, // Название вакансии
    val address: String, // Адрес
    val company: String, // Компания
    val experience: String, // Опыт работы
    val publishedDate: String, // Дата публикации
    val isFavorite: Boolean, // Избранное (true/false)
    val salary: String, // Зарплата
    val schedules: List<String>, // Расписания
    val appliedNumber: Int, // Количество откликов
    val description: String, // Описание вакансии
    val responsibilities: String, // Обязанности
    val questions: List<String> // Вопросы
)