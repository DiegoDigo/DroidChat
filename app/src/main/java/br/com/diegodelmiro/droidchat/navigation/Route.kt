package br.com.diegodelmiro.droidchat.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    object SplashDestination

    @Serializable
    object SignInDestination

    @Serializable
    object SignUpDestination
}