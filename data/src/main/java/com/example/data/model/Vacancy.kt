package com.example.data.model

import com.example.data.mapper.Mapper
import com.example.domain.model.JobVacancy
import com.google.gson.annotations.SerializedName

data class Vacancy(
    @SerializedName("id")
    val id: String,

    @SerializedName("lookingNumber")
    val lookingNumber: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("address")
    val address: Address,

    @SerializedName("company")
    val company: String,

    @SerializedName("experience")
    val experience: Experience,

    @SerializedName("publishedDate")
    val publishedDate: String,

    @SerializedName("isFavorite")
    val isFavorite: Boolean,

    @SerializedName("salary")
    val salary: Salary,

    @SerializedName("schedules")
    val schedules: List<String>,

    @SerializedName("appliedNumber")
    val appliedNumber: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("responsibilities")
    val responsibilities: String,

    @SerializedName("questions")
    val questions: List<String>
): Mapper<Vacancy, JobVacancy> {
    override fun toDomain(model: Vacancy): JobVacancy {
        return JobVacancy(
            id = id,
            lookingNumber = lookingNumber,
            title = title,
            address = address.town,
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
}
