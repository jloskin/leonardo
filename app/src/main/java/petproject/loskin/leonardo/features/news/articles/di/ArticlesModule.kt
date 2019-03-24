package petproject.loskin.leonardo.features.news.articles.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.news.articles.services.ArticlesService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class ArticlesModule {
    @Provides
    fun service(
        retrofit: Retrofit
    ): ArticlesService = retrofit.create(ArticlesService::class.java)
}
