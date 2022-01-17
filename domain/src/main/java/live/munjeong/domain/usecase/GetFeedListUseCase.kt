package live.munjeong.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.single
import live.munjeong.domain.model.Feed
import live.munjeong.domain.repository.FeedRepository
import javax.inject.Inject

class GetFeedListUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    private val repository: FeedRepository,
) : UseCase<String, List<Feed>>(dispatcher) {
    override suspend fun execute(parameters: String): List<Feed> {
        return repository.getFeeds(parameters).single()
    }
}