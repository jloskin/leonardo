package petproject.loskin.leonardo.util

import androidx.lifecycle.LiveData

class AbsentLiveData<T> private constructor() : LiveData<T>() {
  init {
    postValue(null)
  }

  companion object {
    fun <T> create(): LiveData<T> {
      return AbsentLiveData()
    }
  }
}