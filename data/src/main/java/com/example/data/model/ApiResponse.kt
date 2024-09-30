package com.example.data.model

import com.example.domain.model.JobVacancy

data class ApiResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)

data class Offer(
    val id: String,
    val title: String,
    val link: String,
    val button: Button? = null
)

data class Button(
    val text: String
)

data class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: Address,
    val company: String,
    val experience: Experience,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: Salary,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)

data class Address(
    val town: String,
    val street: String,
    val house: String
)

data class Experience(
    val previewText: String,
    val text: String
)

data class Salary(
    val short: String? = null,
    val full: String
)

fun Vacancy.toDomain(): JobVacancy {
    return JobVacancy(
        id = id,
        title = title,
        address = address.town + ", " + address.street + ", " + address.house,
        company = company,
        experience = experience.text ?: "",
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = salary.full ?: "Не указана",
        schedules = schedules,
        appliedNumber = appliedNumber,
        description = description ?: "Нет описания",
        responsibilities = responsibilities,
        questions = questions
    )
}