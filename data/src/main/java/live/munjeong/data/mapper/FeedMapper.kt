package live.munjeong.data.mapper

import live.munjeong.data.model.FeedData
import live.munjeong.data.model.UserData
import live.munjeong.domain.model.Feed
import live.munjeong.domain.model.User

internal fun FeedData.toDomainModel() = Feed(user.toDomainModel(), date, photos, content)
internal fun UserData.toDomainModel() = User(name, photo)