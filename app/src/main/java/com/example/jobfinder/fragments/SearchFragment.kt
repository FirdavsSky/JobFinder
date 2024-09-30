package com.example.jobfinder.fragments

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.jobfinder.R
import com.example.jobfinder.core_ui.BaseFragment
import com.example.jobfinder.adapter.JobVacancyAdapter
import com.example.jobfinder.utils.findViewById
import com.example.jobfinder.viewModel.VacanciesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchFragment : BaseFragment(R.layout.fragment_search) {
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: VacanciesViewModel by viewModel()
    private lateinit var vacanciesRecyclerView: RecyclerView
    private lateinit var jobVacancyAdapter: JobVacancyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onInitViews() {
        super.onInitViews()
        vacanciesRecyclerView = findViewById(R.id.rc_search_fragment)

        // Инициализация адаптера
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
            jobVacancyAdapter.notifyDataSetChanged() // Не рекамендуеться это использовать
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
