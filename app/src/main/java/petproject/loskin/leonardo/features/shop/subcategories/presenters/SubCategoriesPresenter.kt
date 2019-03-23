package petproject.loskin.leonardo.features.shop.subcategories.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.shop.subcategories.repositories.SubCategoriesRepository
import petproject.loskin.leonardo.features.shop.subcategories.ui.SubCategoriesView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class SubCategoriesPresenter @Inject constructor(
  link: String,
  repository: SubCategoriesRepository
) : MvpPresenter<SubCategoriesView>() {
  init {
    repository.load(link)
      .applySchedulers()
      .subscribe(viewState::update, Throwable::printStackTrace)
  }
}