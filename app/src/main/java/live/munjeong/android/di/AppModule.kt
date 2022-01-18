package live.munjeong.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import live.munjeong.data.network.MunJeongApi
import live.munjeong.data.repository.FakeFeedRepository
import live.munjeong.data.repository.FeedRepositoryImpl
import live.munjeong.domain.repository.FeedRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFeedRepository(api: MunJeongApi): FeedRepository {
        return FakeFeedRepository()
    }

    @Provides
    @Singleton
    fun providesDispatcherIO(): CoroutineDispatcher = Dispatchers.IO
}