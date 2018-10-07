package petproject.loskin.leonardo.data.entity

data class ItemL(
        val img: String,
        val itemName: String,
        val urlItem: String,
        val price: Price,
        val oldPrice: Price? = null
)

