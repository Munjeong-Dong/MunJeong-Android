package live.munjeong.presentation.feed

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import live.munjeong.domain.model.Feed
import live.munjeong.presentation.navigation.MunJeongDestinations


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeedScreen(
    navController: NavController,
    viewModel: FeedListViewModel,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context: Context = LocalContext.current
    val list by viewModel.list.collectAsState()

    LazyColumn {
        stickyHeader {
            Text(text = "HEADER", color = Color.LightGray)
        }

        items(list) {
            FeedContent(feed = it)
        }
    }
}

@Composable
fun FeedContent(feed: Feed) {
    Text(text = "Item: ${feed.content}", color = Color.LightGray)
}