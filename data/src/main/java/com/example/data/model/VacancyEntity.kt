package com.example.data.model

import com.example.domain.model.Vacancy

data class VacancyEntity(
    val id: String, // Идентификатор
    val title: String, // Название вакансии
    val address: Address, // Адрес
    val company: String, // Компания
    val experience: Experience, // Опыт работы
    val publishedDate: String, // Дата публикации
    val isFavorite: Boolean, // Избранное (true/false)
    val salary: Salary, // Зарплата
    val schedules: List<String>, // Расписания
    val appliedNumber: Int, // Количество откликов
    val description: String, // Описание вакансии
    val responsibilities: String, // Обязанности
    val questions: List<String> // Вопросы
)

data class Address(
    val town: String, // Город
    val street: String, // Улица
    val house: String // Дом
)

data class Experience(
    val previewText: String, // Предварительный текст опыта
    val text: String // Полный текст опыта
)

data class Salary(
    val short: String? = null, // Короткая зарплата (опционально)
    val full: String // Полная зарплата
)

fun VacancyEntity.toDomain(): Vacancy {
    return Vacancy(
        id = id,
        title = title,
        address = address.town + ", " + address.street + ", " + address.house, // Форматированный адрес
        company = company,
        experience = experience.text, // Полный текст опыта
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = salary.full, // Полная зарплата
        schedules = schedules,
        appliedNumber = appliedNumber,
        description = description,
        responsibilities = responsibilities,
        questions = questions
    )
}
