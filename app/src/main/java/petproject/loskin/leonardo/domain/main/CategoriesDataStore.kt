package petproject.loskin.leonardo.domain.main

import io.reactivex.subjects.PublishSubject
import petproject.loskin.leonardo.data.entity.magazine.CategoriesData
import javax.inject.Inject

class CategoriesDataStore @Inject constructor() {
    val categories: PublishSubject<List<CategoriesData>> = PublishSubject.create()
}
