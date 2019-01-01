package petproject.loskin.leonardo.domain.model.main

import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.data.db.dao.profile.ProfileDao
import petproject.loskin.leonardo.util.rx.applySchedulers

class MainViewModel(
  private val profileDao: ProfileDao
) : ViewModel() {
  fun authorize() = profileDao.getUser().applySchedulers()
}
