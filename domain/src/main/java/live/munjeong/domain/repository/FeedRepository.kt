package live.munjeong.domain.repository

import kotlinx.coroutines.flow.Flow
import live.munjeong.domain.model.Feed

interface FeedRepository {
    fun getFeeds(memberId: String): Flow<List<Feed>>
}