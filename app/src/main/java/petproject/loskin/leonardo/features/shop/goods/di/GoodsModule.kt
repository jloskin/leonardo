package petproject.loskin.leonardo.features.shop.goods.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.base.network.NetworkModule
import petproject.loskin.leonardo.features.shop.goods.services.GoodsService
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class GoodsModule(
    @get:Provides val link: String
) {
    @Provides
    fun service(
        retrofit: Retrofit
    ): GoodsService = retrofit.create(GoodsService::class.java)
}