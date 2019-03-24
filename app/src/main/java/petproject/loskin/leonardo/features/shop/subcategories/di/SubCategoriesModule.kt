package petproject.loskin.leonardo.features.shop.subcategories.di

import dagger.Module
import dagger.Provides

@Module
class SubCategoriesModule(
    @get:Provides val link: String
)