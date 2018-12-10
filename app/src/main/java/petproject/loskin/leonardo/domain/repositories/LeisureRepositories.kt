package petproject.loskin.leonardo.domain.repositories

import petproject.loskin.leonardo.data.network.services.news.NewsService
import petproject.loskin.leonardo.domain.repositories.profile.authorize.RetrofitRepository

class LeisureRepositories : RetrofitRepository<NewsService>(NewsService::class.java, "https://leonardo.ru/") {
  fun getNews() = service.news()

  fun getCompetitions() = service.competitions()

  fun getMClasses() = service.mClasses()

  fun getArticles() = service.articles()
}
