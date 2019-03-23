package petproject.loskin.leonardo.features.news.base.models

data class NewsBlock(
  val imgUrl: String,
  val titleName: String,
  val url: String,
  val text: String,
  val date: String,
  val likeCount: String
)