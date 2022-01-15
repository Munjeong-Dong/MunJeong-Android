package live.munjeong.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import live.munjeong.presentation.feed.FeedRoute
import live.munjeong.presentation.feed.FeedScreen
import live.munjeong.presentation.friend.FriendScreen
import live.munjeong.presentation.post.write.PostWriteScreen

@Composable
fun MunJeongNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MunJeongDestinations.FEED_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(MunJeongDestinations.FEED_ROUTE) {
            FeedRoute(navController)
        }
        composable(MunJeongDestinations.FRIEND_ROUTE) {
            FriendScreen(navController)
        }
        composable(MunJeongDestinations.CREATE_POST_ROUTE) {
            PostWriteScreen(navController)
        }
    }
}