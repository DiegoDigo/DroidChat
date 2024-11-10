package br.com.diegodelmiro.droidchat.ui.feature.signup

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import br.com.diegodelmiro.droidchat.ui.components.PrimaryButtonField
import br.com.diegodelmiro.droidchat.ui.components.ProfilePictureOptionModalBottomSheet
import br.com.diegodelmiro.droidchat.ui.components.ProfilePictureSelector
import br.com.diegodelmiro.droidchat.ui.components.SecondaryTextField
import br.com.diegodelmiro.droidchat.ui.theme.BackgroundGradient
import br.com.diegodelmiro.droidchat.ui.theme.DroidChatTheme

@Composable
fun SignUpRoute() {
    SignUpScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SignUpScreen() {
    Box(
        modifier = Modifier
            .background(brush = BackgroundGradient)
            .verticalScroll(state = rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            val profilePictureSeletedUri by remember {
                mutableStateOf<Uri?>(null)
            }

            var showModalBottomSheet by remember {
                mutableStateOf(false)
            }

            Spacer(modifier = Modifier.height(52.dp))
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                Modifier
                    .fillMaxSize(),
                shape = MaterialTheme.shapes.extraLarge.copy(
                    bottomStart = CornerSize(0.dp),
                    bottomEnd = CornerSize(0.dp)
                ),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    ProfilePictureSelector(
                        imageUri = profilePictureSeletedUri,
                        modifier = Modifier.clickable {
                            showModalBottomSheet = true
                        }
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    SecondaryTextField(
                        label = stringResource(R.string.feature_sign_up_first_name),
                        value = "",
                        onValueChange = {}
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    SecondaryTextField(
                        label = stringResource(R.string.feature_sign_up_last_name),
                        value = "",
                        onValueChange = {}
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    SecondaryTextField(
                        label = stringResource(R.string.feature_sign_up_email),
                        value = "",
                        onValueChange = {},
                        keyboardType = KeyboardType.Email,
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    SecondaryTextField(
                        label = stringResource(R.string.feature_sign_up_password),
                        value = "",
                        onValueChange = {},
                        keyboardType = KeyboardType.Password,
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    SecondaryTextField(
                        label = stringResource(R.string.feature_sign_up_password_confirmation),
                        value = "",
                        onValueChange = {},
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                    Spacer(modifier = Modifier.height(36.dp))
                    PrimaryButtonField(
                        text = stringResource(R.string.feature_sign_up_button),
                        onClick = {}
                    )
                }
            }
            if (showModalBottomSheet) {
                ProfilePictureOptionModalBottomSheet(
                    onDismissRequest = { showModalBottomSheet = false }
                )
            }
        }

    }

}

@Preview
@Composable
private fun SignUpRouteScreenPreview() {
    DroidChatTheme {
        SignUpScreen()
    }
}