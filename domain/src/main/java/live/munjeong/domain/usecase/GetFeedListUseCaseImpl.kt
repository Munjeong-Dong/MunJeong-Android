package live.munjeong.domain.usecase

import kotlinx.coroutines.flow.Flow
import live.munjeong.domain.model.Feed
import live.munjeong.domain.repository.FeedRepository

class GetFeedListUseCaseImpl(private val repository: FeedRepository) : GetFeedListUseCase {
    override suspend fun invoke(memberId: String): Flow<List<Feed>> {
        return repository.getFeeds()
    }
}