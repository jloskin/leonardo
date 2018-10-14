package petproject.loskin.leonardo.data.entity.magazine

import dagger.Module
import dagger.android.ContributesAndroidInjector
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment

@Module
abstract class CategoriesModule {
    @ContributesAndroidInjector
    abstract fun bind(): CategoriesFragment
}