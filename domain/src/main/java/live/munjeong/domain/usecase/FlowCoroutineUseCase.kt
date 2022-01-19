package live.munjeong.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowCoroutineUseCase<in P, out R>(
    private val dispatcher: CoroutineDispatcher
) {
    abstract fun execute(params: P): Flow<R>

    operator fun invoke(params: P): Flow<R> =
        execute(params).flowOn(dispatcher)
}