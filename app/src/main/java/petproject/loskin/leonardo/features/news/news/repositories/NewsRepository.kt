package petproject.loskin.leonardo.features.news.news.repositories

import io.reactivex.Observable
import petproject.loskin.leonardo.features.news.base.models.NewsBlock
import petproject.loskin.leonardo.features.news.news.mappers.NewsMapper
import petproject.loskin.leonardo.features.news.news.services.NewsService
import javax.inject.Inject

class NewsRepository @Inject constructor(
  private val service: NewsService,
  private val mapper: NewsMapper
) {
  fun getNews(): Observable<List<NewsBlock>> = service.news().map(mapper::string2News)
}
