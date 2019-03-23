package petproject.loskin.leonardo.features.news.mclasses.repositories

import io.reactivex.Observable
import petproject.loskin.leonardo.features.news.competitions.models.CompetitionsBlock
import petproject.loskin.leonardo.features.news.mclasses.mappers.MClassesMapper
import petproject.loskin.leonardo.features.news.mclasses.services.MClassesService
import javax.inject.Inject

class MClassesRepository @Inject constructor(
  private val service: MClassesService,
  private val mapper: MClassesMapper
) {
  fun getMClasses(): Observable<List<CompetitionsBlock>> = service.mClasses().map(mapper::string2News)
}
