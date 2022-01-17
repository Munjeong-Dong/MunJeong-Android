package live.munjeong.data.mapper

import live.munjeong.data.model.FeedData
import live.munjeong.domain.model.Feed

internal fun FeedData.toDomainModel() = Feed(date, photos, content)