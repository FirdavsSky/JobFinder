package com.example.jobfinder.fragments

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.JobVacancy
import com.example.jobfinder.R
import com.example.jobfinder.adapter.JobVacancyAdapter
import com.example.jobfinder.core_ui.BaseFragment
import com.example.jobfinder.utils.Const.FAVORITE
import com.example.jobfinder.utils.findViewById
import com.example.jobfinder.viewModel.VacanciesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val windowParam = "window"

class MatchingJobsFragment : BaseFragment(R.layout.fragment_matching_jobs) {

    private var window: String? = null

    private val viewModel: VacanciesViewModel by viewModel()

    private lateinit var vacanciesRecyclerView: RecyclerView

    private lateinit var jobVacancyAdapter: JobVacancyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            window = it.getString(windowParam)
        }
    }

    override fun onInitViews() {
        super.onInitViews()
        vacanciesRecyclerView = findViewById(R.id.rc_search_fragment)

        jobVacancyAdapter = JobVacancyAdapter(
            onFavoriteClick = { jobVacancy ->
                // Обработка нажатия на кнопку "Избранное"
            },
            onApplyClick = { jobVacancy ->
                // Обработка нажатия на кнопку "Подать заявку"
            }
        )
        vacanciesRecyclerView.adapter = jobVacancyAdapter

    }

    override fun onInitListeners() {
        super.onInitListeners()

        jobVacancyAdapter.setListener { jobVacancy ->
            (parentFragment as? MainFragment?)?.transferToMainFragment(jobVacancy)
        }

    }

    override fun onInitObservers() {
        super.onInitObservers()

        observeVacancies()
    }

    private fun observeVacancies() {
        val observer = { vacancies: List<JobVacancy> ->
            jobVacancyAdapter.items = vacancies
            //ToDo: Use DiffUtil
            jobVacancyAdapter.notifyDataSetChanged()
        }

        if (window == FAVORITE) {
            viewModel.vacanciesFavorite.observe(viewLifecycleOwner, observer)
        } else {
            viewModel.vacancies.observe(viewLifecycleOwner, observer)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(window: String) =
            MatchingJobsFragment().apply {
                arguments = Bundle().apply {
                    putString(windowParam, window)
                }
            }
    }

}
