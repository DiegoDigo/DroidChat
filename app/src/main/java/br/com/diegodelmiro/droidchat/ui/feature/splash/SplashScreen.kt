package br.com.diegodelmiro.droidchat.ui.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.diegodelmiro.droidchat.R
import br.com.diegodelmiro.droidchat.ui.theme.BackgroundGradient
import br.com.diegodelmiro.droidchat.ui.theme.DroidChatTheme


@Composable
fun SplashRoute() {
    SplashScreen()
}

@Composable
private fun SplashScreen() {
    Column(
        Modifier
            .background(brush = BackgroundGradient)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = ""
        )
        Spacer(Modifier.height(77.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_safety),
                contentDescription = ""
            )
            Spacer(Modifier.width(8.dp))
            Text(
                stringResource(id = R.string.splash_safety_info),
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
@Preview()
private fun SplashScreenPreview(modifier: Modifier = Modifier) {
    DroidChatTheme {
        SplashScreen()
    }
}