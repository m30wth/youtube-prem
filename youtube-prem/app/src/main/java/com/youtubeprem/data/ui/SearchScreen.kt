// /youtube-prem/data/ui/SearchScreen.kt

package com.youtubeprem.data.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

// Placeholder for a composable function to display a single video item
@Composable
fun VideoListItem(video: com.youtubeprem.data.model.Video, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            // Thumbnail Placeholder
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .padding(end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Thumb", style = MaterialTheme.typography.bodySmall)
            }
            Column {
                Text(text = video.title, style = MaterialTheme.typography.titleMedium)
                Text(text = "Duration: ${video.durationSeconds / 60} min", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = viewModel() // Inject ViewModel here
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("YouTube Prem Downloader") }) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.onSearchQueryChanged(it) },
                label = { Text("Search Videos") },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )

            if (isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }

            if (error != null) {
                Text(text = "Error: $error", color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(16.dp))
            }

            if (searchResults.isNotEmpty()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(searchResults) { video ->
                        VideoListItem(video = video) {
                            // Action: Navigate to Watch/Download Screen
                            println("Selected video for watching/downloading: ${video.title}")
                        }
                    }
                }
            } else if (searchQuery.isNotEmpty() && !isLoading) {
                Text(text = "No videos found for \"$searchQuery\"", modifier = Modifier.padding(16.dp))
            }
        }
    }
}