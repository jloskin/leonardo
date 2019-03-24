package petproject.loskin.leonardo.features.news.competitions.services

import io.reactivex.Observable
import retrofit2.http.GET

interface CompetitionsService {
    @GET("/competitions/")
    fun competitions(): Observable<String>
}