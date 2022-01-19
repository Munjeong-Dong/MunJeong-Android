package live.munjeong.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import live.munjeong.presentation.navigation.MunJeongNavGraph

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashWasDisplayed = savedInstanceState != null
        if (!splashWasDisplayed) {
            startSplash()
        } else {
            setContent()
        }
    }

    private fun startSplash() {
        val splashScreen = installSplashScreen()

        splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
            splashScreenViewProvider.iconView
                .animate()
                .setDuration(300)
                .alpha(0f)
                .withEndAction {
                    splashScreenViewProvider.remove()
                    setContent()
                }.start()
        }
    }

    private fun setContent() {
        setContent {
            MunJeongApp()
        }
    }
}