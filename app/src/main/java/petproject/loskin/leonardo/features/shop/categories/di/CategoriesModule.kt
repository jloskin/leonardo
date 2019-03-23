package petproject.loskin.leonardo.features.shop.categories.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.shop.categories.services.CategoriesService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class CategoriesModule {
    @Provides
    fun categoriesService(
            retrofit: Retrofit
    ): CategoriesService = retrofit.create(CategoriesService::class.java)
}
