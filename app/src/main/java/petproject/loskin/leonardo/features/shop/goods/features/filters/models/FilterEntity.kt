package petproject.loskin.leonardo.features.shop.goods.features.filters.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilterEntity(
  val value: String,
  val description: String
) : Parcelable