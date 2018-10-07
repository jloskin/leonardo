package petproject.loskin.leonardo.data.entity

data class MenuL(
        val url: String,
        val name: String,
        val inner: List<MenuL> = listOf()
)