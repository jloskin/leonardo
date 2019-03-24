package petproject.loskin.leonardo.features.profile.cities.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.profile.cities.services.CitiesService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class CitiesModule {
    @Provides
    fun service(
        retrofit: Retrofit
    ): CitiesService = retrofit.create(CitiesService::class.java)
}
