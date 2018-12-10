package petproject.loskin.leonardo.presentation.ui

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.db.dao.profile.ProfileDao

class MainViewModel(
  private val profileDao: ProfileDao
) : ViewModel() {
  fun authorize() = profileDao.getUser()
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
}
