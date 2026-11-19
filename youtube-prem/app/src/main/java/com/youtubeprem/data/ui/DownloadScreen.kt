// /youtube-prem/data/ui/DownloadScreen.kt

package com.youtubeprem.data.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.youtubeprem.data.model.Video
import com.youtubeprem.data.repository.DownloadRepository
import kotlinx.coroutines.launch

@Composable
fun DownloadScreen(
    video: Video,
    downloadRepository: DownloadRepository = DownloadRepository() // Dependency injection placeholder
) {
    var downloadStatus by remember { mutableStateOf("Ready to download") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Downloading Video: ${video.title}", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                downloadStatus = "Starting download..."
                coroutineScope.launch {
                    // Call the repository function to start the download
                    val result = downloadRepository.downloadVideo(video)

                    if (result.isSuccess) {
                        downloadStatus = "✅ Success: ${result.getOrNull()}"
                    } else {
                        downloadStatus = "❌ Failed: ${result.exceptionOrNull()?.message ?: "Unknown error"}"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Start Download (1080p)")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Status:", style = MaterialTheme.typography.titleMedium)
        Text(text = downloadStatus, color = if (downloadStatus.startsWith("✅")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error)
    }
}