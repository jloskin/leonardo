package petproject.loskin.leonardo.repositories

import petproject.loskin.leonardo.data.network.GetDataService
import petproject.loskin.leonardo.data.network.RetrofitClientInstance
import javax.inject.Inject

class MainRepositories @Inject constructor() {
    private val service = RetrofitClientInstance.retrofit.create(GetDataService::class.java)

    fun getAllPhotos() = service.getAllPhotos()

    fun getUrl(url: String) = service.getUrl(url)

    fun getNews() = service.getNews()

    fun getCompetitions() = service.getCompetitions()

    fun getMClasses() = service.getMClasses()

    fun getArticles() = service.getArticles()

    fun loadGoodsCategories() = service.loadGoodsCategories()

    fun authorize(login: String, password: String) = service.authorize(login, password)

    fun orders() = service.orders()
}
