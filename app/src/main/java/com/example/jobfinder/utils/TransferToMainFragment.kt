package com.example.jobfinder.utils

import com.example.domain.model.JobVacancy

interface TransferToMainFragment {
    fun transferToMainFragment(jobVacancy: JobVacancy)
}