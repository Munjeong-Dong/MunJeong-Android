package live.munjeong.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import live.munjeong.domain.model.Feed
import live.munjeong.domain.repository.FeedRepository

interface GetFeedListUseCase {
    suspend operator fun invoke(memberId: String): Flow<List<Feed>>
}