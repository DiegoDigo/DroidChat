package br.com.diegodelmiro.droidchat.ui.components

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.diegodelmiro.droidchat.R
import br.com.diegodelmiro.droidchat.ui.theme.DroidChatTheme
import coil.compose.AsyncImage

@Composable
fun ProfilePictureSelector(modifier: Modifier = Modifier, imageUri: Uri? = null) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            modifier = Modifier
                .size(84.dp)
                .clip(CircleShape),
            model = imageUri ?: R.drawable.ic_upload_photo,
            contentDescription = "",
            placeholder = painterResource(R.drawable.ic_upload_photo),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.common_add_profile_photo),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfilePictureSelectorPreview() {
    DroidChatTheme {
        ProfilePictureSelector()
    }
}