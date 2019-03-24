package petproject.loskin.leonardo.base.db.di

import dagger.Module
import dagger.Provides
import petproject.loskin.leonardo.App
import petproject.loskin.leonardo.base.db.AppDatabase

@Module
class DataBaseModule {
    @get:Provides
    val database = AppDatabase.getInstance(App.context)

    @Provides
    fun categoriesDao(
        appDatabase: AppDatabase
    ) = appDatabase.categoriesDao()

    @Provides
    fun profileDao(
        appDatabase: AppDatabase
    ) = appDatabase.profileDao()
}
