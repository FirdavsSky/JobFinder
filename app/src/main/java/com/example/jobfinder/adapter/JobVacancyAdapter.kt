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
import java.text.SimpleDateFormat
import java.util.*

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
                item.apply {
                    lookingTextView.text = if (lookingNumber != 0){
                        "Сейчас просматривает ${lookingNumber} человек"
                    } else{
                        ""
                    }
                    titleTextView.text = title
                    addressTextView.text = address
                    companyTextView.text = company
                    textExperience.text = "Опыт ${experience}"
                    textPublishedDate.text = getFormattedDate(publishedDate)


                    // Обработка состояния кнопки "Избранное"
                    favoriteButton.setImageResource(
                        if (isFavorite) R.drawable.ic_heart_active else R.drawable.ic_heart
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

    private fun getFormattedDate(dateStr: String): String {

        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date: Date? = inputFormat.parse(dateStr)


        val dayFormat = SimpleDateFormat("d", Locale.getDefault())
        val monthFormat = SimpleDateFormat("M", Locale.getDefault())

        val day = dayFormat.format(date).toInt()
        val month = monthFormat.format(date).toInt()


        val monthName = getMonthNameWithDeclension(month, day)

        return "Опубликовано $day $monthName"
    }

    private fun getMonthNameWithDeclension(month: Int, day: Int): String {
        return when (month) {
            1 -> if (day == 1) "январь" else "января"
            2 -> if (day == 1) "февраль" else "февраля"
            3 -> if (day == 1) "март" else "марта"
            4 -> if (day == 1) "апрель" else "апреля"
            5 -> if (day == 1) "май" else "мая"
            6 -> if (day == 1) "июнь" else "июня"
            7 -> if (day == 1) "июль" else "июля"
            8 -> if (day == 1) "август" else "августа"
            9 -> if (day == 1) "сентябрь" else "сентября"
            10 -> if (day == 1) "октябрь" else "октября"
            11 -> if (day == 1) "ноябрь" else "ноября"
            12 -> if (day == 1) "декабрь" else "декабря"
            else -> ""
        }
    }
}