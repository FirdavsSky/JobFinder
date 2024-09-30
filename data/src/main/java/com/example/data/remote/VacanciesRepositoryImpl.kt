package com.example.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.model.toDomain
import com.example.data.remote.RetrofitInstance.api
import com.example.domain.model.JobVacancy
import com.example.domain.repository.VacanciesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class VacanciesRepositoryImpl() : VacanciesRepository {


    override fun getAllVacancies(): LiveData<List<JobVacancy>> {

        val vacanciesLiveData = MutableLiveData<List<JobVacancy>>()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val vacancyEntities = api.fetchAllVacancies().vacancies
                val vacancies = vacancyEntities.map { it.toDomain() }
                withContext(Dispatchers.Main) {
                    vacanciesLiveData.value = vacancies
                }
            } catch (e: Exception) {
                Log.e("Error", "Ошибка при получении вакансий: ${e.message}")
                vacanciesLiveData.postValue(emptyList())
            }
        }

        return vacanciesLiveData
    }

    override fun getVacancyById(id: String): LiveData<JobVacancy?> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorites(jobVacancy: JobVacancy) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites(vacancyId: String) {
        TODO("Not yet implemented")
    }

    override fun getFavoriteVacancies(): LiveData<List<JobVacancy>> {
        TODO("Not yet implemented")
    }

    override fun searchVacancies(query: String): LiveData<List<JobVacancy>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateVacancy(jobVacancy: JobVacancy) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVacancy(vacancyId: String) {
        TODO("Not yet implemented")
    }

}
