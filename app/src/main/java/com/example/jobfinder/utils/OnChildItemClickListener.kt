package com.example.jobfinder.utils

import com.example.domain.model.JobVacancy

fun interface OnJobItemClickListener {
    fun onJobItemClicked(jobVacancy: JobVacancy)
}