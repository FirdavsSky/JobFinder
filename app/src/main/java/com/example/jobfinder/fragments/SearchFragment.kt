package com.example.jobfinder.fragments

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.jobfinder.R
import com.example.jobfinder.adapter.JobVacancyAdapter
import com.example.jobfinder.core_ui.BaseFragment
import com.example.jobfinder.utils.findViewById
import com.example.jobfinder.viewModel.VacanciesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment(R.layout.fragment_search) {


    private val viewModel: VacanciesViewModel by viewModel()
    private lateinit var vacanciesRecyclerView: RecyclerView
    private lateinit var jobVacancyAdapter: JobVacancyAdapter

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

        viewModel.vacancies.observe(viewLifecycleOwner) { vacancies ->
            Log.d("Vacancies", vacancies.toString())
            jobVacancyAdapter.items = vacancies
            jobVacancyAdapter.notifyDataSetChanged() // Не рекамендуеться это использовать (DiffUtil лучше использовать)
        }

        jobVacancyAdapter.setListener { jobVacancy ->
            (parentFragment as? MainFragment?)?.transferToMainFragment(jobVacancy)
        }

    }

}
