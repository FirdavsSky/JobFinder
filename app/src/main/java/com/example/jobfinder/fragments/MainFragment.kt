package com.example.jobfinder.fragments


import com.example.domain.model.JobVacancy
import com.example.jobfinder.R
import com.example.jobfinder.core_ui.BaseFragment
import com.example.jobfinder.utils.TransferToMainFragment



class MainFragment : BaseFragment(R.layout.fragment_main), TransferToMainFragment {

    override fun transferToMainFragment(jobVacancy: JobVacancy) {
        val vacanciesPageFragment = VacanciesPageFragment.newInstance(jobVacancy)
        parentFragmentManager.beginTransaction()
            .add(R.id.main, vacanciesPageFragment)
            .addToBackStack(null)
            .commit()
    }
}