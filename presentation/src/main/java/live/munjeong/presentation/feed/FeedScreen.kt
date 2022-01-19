package live.munjeong.presentation.feed

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import live.munjeong.domain.model.Feed
import live.munjeong.domain.model.User
import live.munjeong.presentation.ui.theme.MunJeongTheme

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
        items(list) {
            FeedContent(feed = it)
        }
    }
}

@Composable
fun FeedContent(feed: Feed) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(feed.user.photo, builder = {
                    transformations(CircleCropTransformation())
                }),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = null,
                modifier = Modifier
                    .padding(0.dp, 4.dp)
                    .width(40.dp)
                    .aspectRatio(1f, true)
            )

            Text(
                text = feed.user.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(8.dp, 0.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        }

        Image(
            painter = rememberImagePainter(feed.photos.first()),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1f, true)
        )

        Text(text = "Date - ${feed.date}", style = MaterialTheme.typography.body1)

        Text(text = "content - ${feed.content}", style = MaterialTheme.typography.body2)
    }
}

@Preview("feedContent", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("feedContent (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FeedContentPreview() {
    MunJeongTheme {
        Surface {
            FeedContent(
                feed = Feed(
                    User(
                        "sangcomz",
                        "https://www.cameraegg.org/wp-content/uploads/2012/09/Sony-DSC-RX1-Sample-Image.jpg"
                    ),
                    "2022-01-01",
                    listOf("https://www.cameraegg.org/wp-content/uploads/2012/09/Sony-DSC-RX1-Sample-Image.jpg"),
                    "content"
                )
            )
        }
    }
}