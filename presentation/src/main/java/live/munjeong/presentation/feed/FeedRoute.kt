package live.munjeong.presentation.feed

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun FeedRoute(navHostController: NavHostController) {
    val viewModel: FeedListViewModel = hiltViewModel()

    FeedScreen(viewModel = viewModel, navController = navHostController)
}