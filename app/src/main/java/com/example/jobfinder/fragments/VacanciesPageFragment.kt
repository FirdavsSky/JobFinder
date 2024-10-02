package com.example.jobfinder.fragments

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import com.example.domain.model.JobVacancy
import com.example.jobfinder.R
import com.example.jobfinder.core_ui.BaseFragment
import com.example.jobfinder.utils.findViewById

private const val JOB_PARAM = "jobVacancy"

class VacanciesPageFragment : BaseFragment(R.layout.fragment_vacancies_page) {

    private var jobVacancy: JobVacancy? = null

    private lateinit var buttonArrowBack: ImageButton
    private lateinit var buttonEye: ImageButton
    private lateinit var buttonShare: ImageButton
    private lateinit var buttonFavorite: ImageButton
    private lateinit var textJobTitle: TextView
    private lateinit var textIncomeTitle: TextView
    private lateinit var textExperience: TextView
    private lateinit var textTypeOfEmployment: TextView
    private lateinit var textResponded: TextView
    private lateinit var textViewers: TextView
    private lateinit var company: TextView
    private lateinit var responsibilities: TextView
    private lateinit var listView: ListView
    private lateinit var listAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            jobVacancy = it.getParcelable(JOB_PARAM)
        }
    }

    override fun onInitViews() {
        super.onInitViews()
        initializeViews()
        populateData()
    }

    private fun initializeViews() {
        buttonArrowBack = findViewById(R.id.button_arrow_left)
        buttonEye = findViewById(R.id.button_eye)
        buttonShare = findViewById(R.id.button_share)
        buttonFavorite = findViewById(R.id.button_favorite)
        textJobTitle = findViewById(R.id.text_job_title)
        textIncomeTitle = findViewById(R.id.text_income_title)
        textExperience = findViewById(R.id.text_experience)
        textTypeOfEmployment = findViewById(R.id.text_type_of_employment)
        textResponded = findViewById(R.id.textResponded)
        textViewers = findViewById(R.id.text_viewers)
        company = findViewById(R.id.text_company)
        responsibilities = findViewById(R.id.text_responsibilities)
        listView = findViewById(R.id.questionList)
    }

    override fun onInitListeners() {
        super.onInitListeners()

        buttonArrowBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun populateData() {

        jobVacancy?.let {

            with(it) {

                buttonFavorite.setImageResource(
                    if (isFavorite) R.drawable.ic_heart_active else R.drawable.ic_heart
                )
                textJobTitle.text = title
                textIncomeTitle.text = salary
                textExperience.text =
                    getString(R.string.required_experience, experience)

                textTypeOfEmployment.text = formatSchedules(schedules)
                textResponded.text = getString(R.string.applied_count, appliedNumber)
                textViewers.text = getString(R.string.viewers_count, lookingNumber)

                this@VacanciesPageFragment.company.text = getString(
                    R.string.company_description,
                    company,
                    description
                )
                this@VacanciesPageFragment.responsibilities.text = responsibilities

                listAdapter = ArrayAdapter(
                    requireContext(),
                    R.layout.item_question,
                    R.id.text_question,
                    questions
                )
                listView.adapter = listAdapter
            }
        }
    }

    private fun formatSchedules(schedules: List<String>?): String {
        return schedules?.joinToString(separator = ", ") { it.lowercase() }
            ?.replaceFirstChar { it.uppercase() }
            ?: ""
    }

    companion object {
        @JvmStatic
        fun newInstance(jobVacancy: JobVacancy) =
            VacanciesPageFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(JOB_PARAM, jobVacancy)
                }
            }
    }
}
