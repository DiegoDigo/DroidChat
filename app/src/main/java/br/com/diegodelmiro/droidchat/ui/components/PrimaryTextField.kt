package br.com.diegodelmiro.droidchat.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.diegodelmiro.droidchat.R
import br.com.diegodelmiro.droidchat.ui.theme.DroidChatTheme


@Composable
fun PrimaryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    errorMessages: String? = null,
    placeholder: String? = null,
    @DrawableRes
    leadingIcon: Int? = null,
    keyBoardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next
) {

    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = keyBoardType, imeAction = imeAction),
            leadingIcon = {
                leadingIcon?.let {
                    Icon(
                        painter = painterResource(id = leadingIcon),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            trailingIcon = {
                if (keyBoardType == KeyboardType.Password && value.isNotEmpty()) {
                    val visibilityIcon = if (passwordVisible) {
                        R.drawable.ic_visibility
                    } else {
                        R.drawable.ic_visibility_off
                    }
                    Icon(
                        painter = painterResource(id = visibilityIcon),
                        contentDescription = "",
                        modifier = Modifier.clickable { passwordVisible = !passwordVisible },
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            placeholder = { placeholder?.let { Text(it) } },
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = errorMessages?.let { MaterialTheme.colorScheme.error }
                    ?: MaterialTheme.colorScheme.onSurfaceVariant,
            ),
            visualTransformation = if (keyBoardType == KeyboardType.Password && !passwordVisible) {
                PasswordVisualTransformation()
            } else VisualTransformation.None,
            singleLine = true
        )

        errorMessages?.let {
            Text(
                errorMessages,
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colorScheme.error,

                )
        }

    }

}

@Preview
@Composable
private fun PrimaryTextFieldPreview() {
    DroidChatTheme {
        PrimaryTextField(
            "123",
            {},
            errorMessages = "Senha é Obrigatoria",
            leadingIcon = R.drawable.ic_envelope,
            keyBoardType = KeyboardType.Password
        )
    }
}