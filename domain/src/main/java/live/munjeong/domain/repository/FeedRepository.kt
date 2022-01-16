package live.munjeong.domain.repository

import kotlinx.coroutines.flow.Flow
import live.munjeong.domain.model.Feed

interface FeedRepository {
    suspend fun getFeeds(): Flow<List<Feed>>
}