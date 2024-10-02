package com.example.jobfinder.fragments

import androidx.fragment.app.commit
import com.example.domain.model.JobVacancy
import com.example.jobfinder.R
import com.example.jobfinder.core_ui.BaseFragment
import com.example.jobfinder.utils.Const.FAVORITE
import com.example.jobfinder.utils.Const.SEARCH
import com.example.jobfinder.utils.TransferToMainFragment
import com.example.jobfinder.utils.findViewById
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : BaseFragment(R.layout.fragment_main), TransferToMainFragment {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onInitViews() {
        super.onInitViews()
        bottomNavigationView = findViewById(R.id.bottom_navigation)
    }

    override fun onInitListeners() {
        super.onInitListeners()
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            handleNavigationItemSelected(menuItem.itemId)
        }
    }

    private fun handleNavigationItemSelected(itemId: Int): Boolean {
        val fragment = when (itemId) {
            R.id.search -> MatchingJobsFragment.newInstance(SEARCH)
            R.id.heart -> MatchingJobsFragment.newInstance(FAVORITE)
            else -> null
        }
        fragment?.let {
            childFragmentManager.commit {
                replace(R.id.fragmentMainContainerView, it)
                addToBackStack(null)
            }
            return true
        }
        return false
    }

    override fun transferToMainFragment(jobVacancy: JobVacancy) {
        val vacanciesPageFragment = VacanciesPageFragment.newInstance(jobVacancy)
        parentFragmentManager.commit {
            add(R.id.main, vacanciesPageFragment)
            addToBackStack(null)
        }
    }
}