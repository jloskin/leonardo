package petproject.loskin.leonardo.features.news.articles.repositories

import io.reactivex.Observable
import petproject.loskin.leonardo.features.news.base.models.NewsBlock
import petproject.loskin.leonardo.features.news.articles.mappers.ArticlesMapper
import petproject.loskin.leonardo.features.news.articles.services.ArticlesService
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
  private val service: ArticlesService,
  private val mapper: ArticlesMapper
) {
  fun getArticles(): Observable<List<NewsBlock>> = service.articles().map(mapper::string2Articles)
}
