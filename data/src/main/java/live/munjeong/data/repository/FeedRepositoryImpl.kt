package live.munjeong.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import live.munjeong.data.network.MunJeongApi
import live.munjeong.domain.model.Feed
import live.munjeong.domain.repository.FeedRepository
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(private val api: MunJeongApi) : FeedRepository {
    override fun getFeeds(memberId: String): Flow<List<Feed>> {
        TODO("Not yet implemented")
    }
}