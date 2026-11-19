# YouTube Prem Downloader

A Kotlin/MVVM application for downloading YouTube videos in 1080p quality.

## 🚀 Features
*   **Search:** Find videos based on keywords.
*   **Listing:** Browse search results.
*   **Download:** Initiate the download process for selected videos using `youtube-dl`.

## 🛠️ Tech Stack
*   **Language:** Kotlin
*   **Architecture:** MVVM (Model-View-ViewModel)
*   **Platform:** Android

## 📂 Project Structure
The project follows a clean architecture pattern:
*   `data/model`: Data classes for video information.
*   `data/repository`: Handles data operations (API calls, file downloads).
*   `data/ui`: Composable functions and ViewModels for the UI.
*   `utils`: Utility functions.

## ⚙️ Setup & Installation
1.  **Clone the repository.**
2.  **Set up Dependencies:** Configure Gradle files to include necessary libraries (e.g., Coroutines, ViewModel, Hilt).
3.  **Configure API Keys (if using a real API):** Place necessary keys in `local.properties`.

## 🤝 Contributing
Contributions are welcome! Please feel free to open an issue or submit a pull request.

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.