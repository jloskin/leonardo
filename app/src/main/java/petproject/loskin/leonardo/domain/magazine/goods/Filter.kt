package petproject.loskin.leonardo.domain.magazine.goods

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filter(
        val id: String,
        val parentId: List<FilterEntity>
) : Parcelable