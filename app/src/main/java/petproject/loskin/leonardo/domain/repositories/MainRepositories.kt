package petproject.loskin.leonardo.domain.repositories

import petproject.loskin.leonardo.data.network.services.news.NewsService
import petproject.loskin.leonardo.data.network.RetrofitClientInstance

class MainRepositories {
    private val service = RetrofitClientInstance.retrofit.create(NewsService::class.java)
    fun getNews() = service.news()

    fun getCompetitions() = service.competitions()

    fun getMClasses() = service.mClasses()

    fun getArticles() = service.articles()
}
