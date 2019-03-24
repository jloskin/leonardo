package petproject.loskin.leonardo.features.news.mclasses.services

import io.reactivex.Observable
import retrofit2.http.GET

interface MClassesService {
    @GET("/mclasses/")
    fun mClasses(): Observable<String>
}