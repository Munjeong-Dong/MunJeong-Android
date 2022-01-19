package live.munjeong.data.model

data class FeedData(
    val user: UserData,
    val date: String,
    val photos: List<String>,
    val content: String
)
