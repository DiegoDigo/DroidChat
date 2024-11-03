package br.com.diegodelmiro.droidchat.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.diegodelmiro.droidchat.ui.theme.DroidChatTheme

@Composable
fun PrimaryButtonField(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
) {
    Button(
        modifier = modifier
            .height(64.dp),
        onClick = onClick,
        enabled = !isLoading,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
        )
    ) {
        Box(Modifier.animateContentSize()) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(30.dp)
                        .aspectRatio(1f),
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp,
                    strokeCap = StrokeCap.Round,
                )
            } else {
                Text(
                    text,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}

@Preview
@Composable
private fun PrimaryButtonFieldPreview() {
    DroidChatTheme {
        PrimaryButtonField("Sign In", onClick = {})
    }
}

@Preview
@Composable
private fun PrimaryButtonFieldLoadingPreview() {
    DroidChatTheme {
        PrimaryButtonField("Sign In", onClick = {}, isLoading = true)
    }
}