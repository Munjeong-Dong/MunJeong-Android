package live.munjeong.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import live.munjeong.domain.model.Feed
import live.munjeong.domain.repository.FeedRepository
import javax.inject.Inject

class GetFeedListFlowUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    private val repository: FeedRepository,
) : FlowCoroutineUseCase<String, List<Feed>>(dispatcher) {
    override fun execute(params: String): Flow<List<Feed>> {
        return repository.getFeeds(params)
    }
}