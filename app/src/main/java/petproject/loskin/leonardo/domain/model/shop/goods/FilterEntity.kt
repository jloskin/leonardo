package petproject.loskin.leonardo.domain.model.shop.goods

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilterEntity(
  val value: String,
  val description: String
) : Parcelable