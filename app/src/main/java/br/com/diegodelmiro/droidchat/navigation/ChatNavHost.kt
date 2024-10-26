package br.com.diegodelmiro.droidchat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.diegodelmiro.droidchat.ui.feature.splash.SplashRoute
import kotlinx.serialization.Serializable


@Serializable
object SplashDestination

@Serializable
object SignInDestination

@Serializable
object SignUpDestination

@Composable
fun ChatNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SplashDestination) {
        composable<SplashDestination> {
            SplashRoute()
        }
        composable<SignInDestination> {

        }
        composable<SignUpDestination> {

        }
    }
}