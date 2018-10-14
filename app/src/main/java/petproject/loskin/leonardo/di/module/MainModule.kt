package petproject.loskin.leonardo.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import petproject.loskin.leonardo.di.ViewModelKey
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesViewModel
import petproject.loskin.leonardo.presentation.ui.magazine.goods.GoodsFragment
import petproject.loskin.leonardo.presentation.ui.magazine.goods.GoodsViewModel
import petproject.loskin.leonardo.presentation.ui.magazine.subcategories.SubCategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.subcategories.SubCategoriesViewModel

@Module
internal abstract class MainModule {
    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    abstract fun bindCategoriesViewModel(viewModel: CategoriesViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeCategoriesFragment(): CategoriesFragment


    @Binds
    @IntoMap
    @ViewModelKey(SubCategoriesViewModel::class)
    abstract fun bindSubCategoriesViewModel(viewModel: SubCategoriesViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeSubCategoriesFragment(): SubCategoriesFragment


    @Binds
    @IntoMap
    @ViewModelKey(GoodsViewModel::class)
    abstract fun bindGoodsViewModel(viewModel: GoodsViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeGoodsFragment(): GoodsFragment
}