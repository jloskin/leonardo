package petproject.loskin.leonardo.features.news.competitions.repositories

import io.reactivex.Observable
import petproject.loskin.leonardo.features.news.competitions.models.CompetitionsBlock
import petproject.loskin.leonardo.features.news.competitions.services.CompetitionsService
import javax.inject.Inject

class CompetitionsRepositories @Inject constructor(
  private val service: CompetitionsService,
  private val mappers: CompetitionsMapper
) {
  fun getCompetitions(): Observable<List<CompetitionsBlock>> = service.competitions()
    .map(mappers::page2Competitions)
}
