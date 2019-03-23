package petproject.loskin.leonardo.features.shop.goods.features.filters.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filter(
  val id: String,
  val parentId: List<FilterEntity>
) : Parcelable