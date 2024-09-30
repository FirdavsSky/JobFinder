package com.example.jobfinder.adapter

import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.example.domain.model.JobVacancy
import com.example.jobfinder.R
import com.example.jobfinder.utils.OnJobItemClickListener

class JobVacancyAdapter(
    private val onFavoriteClick: (JobVacancy) -> Unit,
    private val onApplyClick: (JobVacancy) -> Unit
) : ListDelegationAdapter<List<JobVacancy>>() {

    private var onJobItemClicked: OnJobItemClickListener? = null

    init {
        delegatesManager.addDelegate(jobVacancyDelegate())
    }

    fun setListener(listener: OnJobItemClickListener) {
        onJobItemClicked = listener
    }

    private fun jobVacancyDelegate(): AdapterDelegate<List<JobVacancy>> {
        return adapterDelegate<JobVacancy, JobVacancy>(R.layout.item_vacancy_card) {
            val lookingTextView: TextView = findViewById(R.id.text_viewers)
            val titleTextView: TextView = findViewById(R.id.text_job_title)
            val addressTextView: TextView = findViewById(R.id.text_location)
            val companyTextView: TextView = findViewById(R.id.text_company)
            val textExperience: TextView = findViewById(R.id.text_experience)
            val textPublishedDate: TextView = findViewById(R.id.text_published_date)

            val favoriteButton: ImageButton = findViewById(R.id.button_favorite)
            val applyButton: Button = findViewById(R.id.button_apply)

            bind {
                lookingTextView.text = "Сейчас просматривает ${item.lookingNumber} человек"
                titleTextView.text = item.title
                addressTextView.text = item.address
                companyTextView.text = item.company
                textExperience.text = "Опыт ${item.experience}"
                textPublishedDate.text = "Опубликовано ${item.publishedDate}"


                // Обработка состояния кнопки "Избранное"
                favoriteButton.setImageResource(
                    if (item.isFavorite) R.drawable.ic_heart_active else R.drawable.ic_heart
                )
                favoriteButton.setOnClickListener { onFavoriteClick(item) }

                applyButton.setOnClickListener { onApplyClick(item) }

                itemView.setOnClickListener {
                    onJobItemClicked?.onJobItemClicked(item)
                }
            }
        }
    }
}