package br.com.diegodelmiro.droidchat.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import br.com.diegodelmiro.droidchat.navigation.extension.slideInTo
import br.com.diegodelmiro.droidchat.navigation.extension.slideOutTo
import br.com.diegodelmiro.droidchat.ui.feature.signin.SingInRoute
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

            SplashRoute(onNavigateToSignIn = {
                navController.navigate(SignInDestination, navOptions = navOptions {
                    popUpTo(SplashDestination) {
                        inclusive = true
                    }
                })
            })
        }
        composable<SignInDestination>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }, exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Left)
            }
        ) {
            SingInRoute(onNavigateToSingUp = {
                navController.navigate(SignUpDestination)
            })
        }
        composable<SignUpDestination>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            }, exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            Text("SignUp")
        }
    }
}