package petproject.loskin.leonardo.features.profile.cities.repositories

import io.reactivex.Flowable
import petproject.loskin.leonardo.base.db.dao.profile.City
import petproject.loskin.leonardo.base.db.dao.profile.CitiesDao
import petproject.loskin.leonardo.features.profile.cities.mappers.CitiesMapper
import petproject.loskin.leonardo.features.profile.cities.services.CitiesService
import javax.inject.Inject

class CitiesRepository @Inject constructor(
    private val dao: CitiesDao,
    private val mapper: CitiesMapper,
    private val service: CitiesService
) {
    fun cities(): Flowable<List<City>> = dao.cities()
        .flatMap {
            if (it.isEmpty()) service.cities().map(mapper::page2Cities).doOnNext(dao::insertCities).flatMap { dao.cities() }
            else Flowable.just(it)
        }
}