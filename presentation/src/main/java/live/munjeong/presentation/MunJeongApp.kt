package live.munjeong.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import live.munjeong.presentation.navigation.MunJeongNavGraph
import live.munjeong.presentation.ui.theme.MunJeongTheme

@Composable
fun MunJeongApp() {
    MunJeongTheme {
        Row(
            Modifier
                .fillMaxSize()
        ) {
            MunJeongNavGraph(
                navController = rememberNavController(),
            )
        }
    }
}