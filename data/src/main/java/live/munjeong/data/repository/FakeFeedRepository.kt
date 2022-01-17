package live.munjeong.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import live.munjeong.data.mapper.toDomainModel
import live.munjeong.data.model.FeedData
import live.munjeong.domain.model.Feed
import live.munjeong.domain.repository.FeedRepository

class FakeFeedRepository : FeedRepository {
    override suspend fun getFeeds(memberId: String): Flow<List<Feed>> {
        return if (shouldRandomlyFail())
            flow { getFakeFeedList().map { it.toDomainModel() } }
        else
            flow { emptyList<Feed>() }
    }

    private fun getFakeFeedList(): List<FeedData> = listOf(
        FeedData(
            "2022-01-01",
            listOf("https://www.cameraegg.org/wp-content/uploads/2012/09/Sony-DSC-RX1-Sample-Image.jpg"),
            "content1"
        ),
        FeedData(
            "2022-01-01",
            listOf("https://www.cameraegg.org/wp-content/uploads/2012/09/Sony-DSC-RX1-Sample-Image.jpg"),
            "content1"
        ),
        FeedData(
            "2022-01-02",
            listOf("https://www.cameraegg.org/wp-content/uploads/2012/09/Sony-DSC-RX1-Sample-Image.jpg"),
            "content1"
        ),
        FeedData(
            "2022-01-03",
            listOf("https://www.cameraegg.org/wp-content/uploads/2012/09/Sony-DSC-RX1-Sample-Image.jpg"),
            "content1"
        )
    )

    private var requestCount = 0

    private fun shouldRandomlyFail(): Boolean = ++requestCount % 5 == 0
}

