package com.example.jobfinder.adapter

import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.example.domain.model.JobVacancy
import com.example.jobfinder.R

class JobVacancyAdapter(
    private val onFavoriteClick: (JobVacancy) -> Unit,
    private val onApplyClick: (JobVacancy) -> Unit
) : ListDelegationAdapter<List<JobVacancy>>() {

    init {
        delegatesManager.addDelegate(jobVacancyDelegate())
    }

    private fun jobVacancyDelegate(): AdapterDelegate<List<JobVacancy>> {
        return adapterDelegate<JobVacancy, JobVacancy>(R.layout.item_vacancy_card) {
            val titleTextView: TextView = findViewById(R.id.text_job_title)
            val companyTextView: TextView = findViewById(R.id.text_company)
            //val salaryTextView: TextView = findViewById(R.id.salaryTextView)
            val addressTextView: TextView = findViewById(R.id.text_location)
            val favoriteButton: ImageButton = findViewById(R.id.button_favorite)
            val applyButton: Button = findViewById(R.id.button_apply)

            bind {
                titleTextView.text = item.title
                companyTextView.text = item.company
                //salaryTextView.text = item.salary
                addressTextView.text = item.address

                // Обработка состояния кнопки "Избранное"
                favoriteButton.setImageResource(
                    if (item.isFavorite) R.drawable.ic_heart_active else R.drawable.ic_heart
                )
                favoriteButton.setOnClickListener { onFavoriteClick(item) }

                applyButton.setOnClickListener { onApplyClick(item) }
            }
        }
    }
}