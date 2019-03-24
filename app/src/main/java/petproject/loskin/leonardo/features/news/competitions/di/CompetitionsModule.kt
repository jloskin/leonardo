package petproject.loskin.leonardo.features.news.competitions.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.news.competitions.services.CompetitionsService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class CompetitionsModule {
    @Provides
    fun service(
        retrofit: Retrofit
    ): CompetitionsService = retrofit.create(CompetitionsService::class.java)
}
