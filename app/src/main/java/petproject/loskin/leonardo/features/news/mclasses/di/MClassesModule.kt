package petproject.loskin.leonardo.features.news.mclasses.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.news.mclasses.services.MClassesService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class MClassesModule {
    @Provides
    fun service(
        retrofit: Retrofit
    ): MClassesService = retrofit.create(MClassesService::class.java)
}
