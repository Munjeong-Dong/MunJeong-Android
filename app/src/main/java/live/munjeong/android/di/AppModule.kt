package live.munjeong.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import live.munjeong.data.network.MunJeongApi
import live.munjeong.data.repository.FeedRepositoryImpl
import live.munjeong.domain.repository.FeedRepository
import live.munjeong.domain.usecase.GetFeedListUseCase
import live.munjeong.domain.usecase.GetFeedListUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideGetFeedListUseCase(feedRepository: FeedRepository): GetFeedListUseCase {
        return GetFeedListUseCaseImpl(feedRepository)
    }

    @Provides
    fun provideFeedRepository(api: MunJeongApi): FeedRepository {
        return FeedRepositoryImpl(api)
    }
}