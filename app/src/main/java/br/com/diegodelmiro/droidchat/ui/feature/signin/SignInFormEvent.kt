package br.com.diegodelmiro.droidchat.ui.feature.signin

sealed interface SignInFormEvent {
    data class EmailChanged(val email: String) : SignInFormEvent
    data class PasswordChanged(val password: String) : SignInFormEvent
    data object Submit : SignInFormEvent

}