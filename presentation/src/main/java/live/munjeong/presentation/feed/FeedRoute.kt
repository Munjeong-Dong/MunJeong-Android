package live.munjeong.presentation.feed

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun FeedRoute(
    navHostController: NavHostController,
    viewModel: FeedListViewModel = hiltViewModel()
) {
    FeedScreen(viewModel = viewModel, navController = navHostController)
}