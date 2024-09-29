package com.example.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.model.toDomain
import com.example.data.remote.RetrofitInstance.api
import com.example.domain.model.Vacancy
import com.example.domain.repository.VacanciesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class VacanciesRepositoryImpl() : VacanciesRepository {


    override fun getAllVacancies(): LiveData<List<Vacancy>> {

        val vacanciesLiveData = MutableLiveData<List<Vacancy>>()

        // Запускаем корутину для выполнения сетевого запроса
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Получаем список вакансий
                val vacancyEntities = api.fetchAllVacancies()

                // Преобразуем VacancyEntity в Vacancy
                val vacancies = vacancyEntities.map { it.toDomain() }

                // Обновляем LiveData на главном потоке
                withContext(Dispatchers.Main) {
                    vacanciesLiveData.value = vacancies
                }
            } catch (e: Exception) {
                Log.e("Error", "Ошибка при получении вакансий: ${e.message}")
                // Обработка ошибок, можно вернуть пустой список или null
                vacanciesLiveData.postValue(emptyList())
            }
        }

        return vacanciesLiveData
    }

    override fun getVacancyById(id: String): LiveData<Vacancy?> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorites(vacancy: Vacancy) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites(vacancyId: String) {
        TODO("Not yet implemented")
    }

    override fun getFavoriteVacancies(): LiveData<List<Vacancy>> {
        TODO("Not yet implemented")
    }

    override fun searchVacancies(query: String): LiveData<List<Vacancy>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateVacancy(vacancy: Vacancy) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVacancy(vacancyId: String) {
        TODO("Not yet implemented")
    }

}
