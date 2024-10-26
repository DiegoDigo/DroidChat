package br.com.diegodelmiro.droidchat.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.diegodelmiro.droidchat.navigation.ChatNavHost


@Composable
fun ChatApp() {
    Scaffold(
        bottomBar = {}
    ) { paddingValues ->
        Box(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            ChatNavHost()
        }
    }
}