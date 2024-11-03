package br.com.diegodelmiro.droidchat.ui.feature.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.diegodelmiro.droidchat.R
import br.com.diegodelmiro.droidchat.ui.components.PrimaryTextField
import br.com.diegodelmiro.droidchat.ui.theme.BackgroundGradient
import br.com.diegodelmiro.droidchat.ui.theme.DroidChatTheme

@Composable
fun SingInRoute() {
    SingInScreen()
}

@Composable
private fun SingInScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(brush = BackgroundGradient)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = ""
        )

        Spacer(Modifier.padding(64.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        PrimaryTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = stringResource(R.string.feature_login_email),
            leadingIcon = R.drawable.ic_envelope,
            keyBoardType = KeyboardType.Email
        )
        Spacer(Modifier.padding(8.dp))
        PrimaryTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = password,
            placeholder = stringResource(R.string.feature_login_password),
            onValueChange = {
                password = it
            },
            leadingIcon = R.drawable.ic_lock,
            keyBoardType = KeyboardType.Password,
            imeAction = ImeAction.Done

        )
    }
}


@Preview
@Composable
private fun SingInScreenPreview() {
    DroidChatTheme {
        SingInScreen()
    }
}