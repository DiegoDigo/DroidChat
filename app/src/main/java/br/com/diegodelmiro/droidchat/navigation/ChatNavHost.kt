package br.com.diegodelmiro.droidchat.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import br.com.diegodelmiro.droidchat.navigation.extension.slideInTo
import br.com.diegodelmiro.droidchat.navigation.extension.slideOutTo
import br.com.diegodelmiro.droidchat.ui.feature.signin.SingInRoute
import br.com.diegodelmiro.droidchat.ui.feature.signup.SignUpRoute
import br.com.diegodelmiro.droidchat.ui.feature.splash.SplashRoute


@Composable
fun ChatNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.SplashDestination) {
        composable<Route.SplashDestination> {

            SplashRoute(onNavigateToSignIn = {
                navController.navigate(Route.SignInDestination, navOptions = navOptions {
                    popUpTo(Route.SplashDestination) {
                        inclusive = true
                    }
                })
            })
        }
        composable<Route.SignInDestination>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }, exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Left)
            }
        ) {
            SingInRoute(onNavigateToSingUp = {
                navController.navigate(Route.SignUpDestination)
            })
        }
        composable<Route.SignUpDestination>(
            enterTransition = {
                this.slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
            }, exitTransition = {
                this.slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            SignUpRoute()
        }
    }
}