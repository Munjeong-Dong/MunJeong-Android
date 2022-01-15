package live.munjeong.presentation.feed

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import live.munjeong.presentation.navigation.MunJeongDestinations


@Composable
fun FeedScreen(
    viewModel: FeedListViewModel,
    navController: NavController
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context: Context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button({
            navController.navigate(MunJeongDestinations.FRIEND_ROUTE)
        }, content = { Text(text = "Go to friendList") })

        Button({
            navController.navigate(MunJeongDestinations.CREATE_POST_ROUTE)
        }, content = { Text(text = "Go to createPost") })
    }
}