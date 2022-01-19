package live.munjeong.domain.model

data class Feed(
    val user: User,
    val date: String,
    val photos: List<String>,
    val content: String
)
