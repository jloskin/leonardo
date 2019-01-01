package petproject.loskin.leonardo.util.rx

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.applySchedulers(): Maybe<T> = this
  .subscribeOn(Schedulers.io())
  .unsubscribeOn(Schedulers.io())
  .observeOn(AndroidSchedulers.mainThread())
  .firstElement()

fun <T> Flowable<T>.applySchedulers(): Maybe<T> = this
  .subscribeOn(Schedulers.io())
  .unsubscribeOn(Schedulers.io())
  .observeOn(AndroidSchedulers.mainThread())
  .firstElement()