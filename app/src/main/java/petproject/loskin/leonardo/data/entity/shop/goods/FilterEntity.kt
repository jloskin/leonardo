package petproject.loskin.leonardo.data.entity.shop.goods

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilterEntity(
  val value: String,
  val description: String
) : Parcelable