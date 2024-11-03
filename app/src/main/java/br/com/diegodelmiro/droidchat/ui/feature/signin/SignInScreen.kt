package br.com.diegodelmiro.droidchat.ui.feature.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.diegodelmiro.droidchat.R
import br.com.diegodelmiro.droidchat.ui.components.PrimaryButtonField
import br.com.diegodelmiro.droidchat.ui.components.PrimaryTextField
import br.com.diegodelmiro.droidchat.ui.theme.BackgroundGradient
import br.com.diegodelmiro.droidchat.ui.theme.DroidChatTheme

@Composable
fun SingInRoute(
    viewModel: SignInViewModel = viewModel()
) {
    val formState = viewModel.formState
    SingInScreen(
        formState = formState,
        onFormEvent = viewModel::onFormEvent
    )
}

@Composable
private fun SingInScreen(
    formState: SignInFormState,
    onFormEvent: (SignInFormEvent) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(brush = BackgroundGradient)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = ""
        )

        Spacer(Modifier.height(78.dp))

        PrimaryTextField(
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.spacing_medium)),
            value = formState.email,
            onValueChange = {
                onFormEvent(SignInFormEvent.EmailChanged(it))
            },
            placeholder = stringResource(R.string.feature_login_email),
            leadingIcon = R.drawable.ic_envelope,
            keyBoardType = KeyboardType.Email,
            errorMessages = formState.emailError?.let { stringResource(it) }
        )
        Spacer(Modifier.height(14.dp))
        PrimaryTextField(
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.spacing_medium)),
            value = formState.password,
            placeholder = stringResource(R.string.feature_login_password),
            onValueChange = {
                onFormEvent(SignInFormEvent.PasswordChanged(it))
            },
            leadingIcon = R.drawable.ic_lock,
            keyBoardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            errorMessages = formState.passwordError?.let { stringResource(it) }
        )
        Spacer(Modifier.height(98.dp))

        PrimaryButtonField(
            text = stringResource(R.string.feature_login_button),
            onClick = {
                onFormEvent(SignInFormEvent.Submit)
            },
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.spacing_medium)),
            isLoading = formState.isLoading
        )
    }
}


@Preview
@Composable
private fun SingInScreenPreview() {
    DroidChatTheme {
        SingInScreen(SignInFormState(), {})
    }
}