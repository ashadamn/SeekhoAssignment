# AnimeExplorer 📺  
A simple Android application that allows users to browse a list of popular anime series, view their details, and watch trailers. Built using Kotlin, Jetpack Compose, and Clean Architecture principles for a scalable and maintainable codebase.

---

## 🌟 Features  
### **Anime List Page**  
- Displays a list of popular/top-rated anime fetched from the Jikan API.  
- Each anime item includes:
  - **Title**  
  - **Number of Episodes**  
  - **Rating** (e.g., MyAnimeList score)  
  - **Poster Image**

### **Anime Detail Page**  
- Displays detailed information about the selected anime, including:  
  - **Title**  
  - **Plot/Synopsis**  
  - **Genres**  
  - **Main Cast**  
  - **Number of Episodes**  
  - **Rating**  
- **Trailer Playback**: Plays the trailer if available. If not, displays the poster image instead.  

---

## 🚀 Tech Stack  
- **Kotlin**  
- **Jetpack Compose**: Modern UI toolkit for building declarative UIs.  
- **Ktor**: Lightweight and flexible HTTP client for network operations.  
- **Koin**: Dependency Injection framework for managing dependencies.  
- **MVVM**: Model-View-ViewModel architecture for separation of concerns.  
- **Clean Architecture**: Ensures scalability and maintainability of the codebase.  

---

## 🛠️ API Usage  
1. **Anime List**  
   - Endpoint: [https://api.jikan.moe/v4/top/anime](https://api.jikan.moe/v4/top/anime)  
   - Fetches a list of popular/top-rated anime series.  

2. **Anime Details**  
   - Endpoint: [https://api.jikan.moe/v4/anime/{anime_id}](https://api.jikan.moe/v4/anime/{anime_id})  
   - Fetches detailed information about a specific anime, including trailer data.

---

## 📂 Project Structure  
The project follows the **Clean Architecture** pattern, organized into three main layers:  
- **Presentation Layer**: Contains UI components and ViewModels (Jetpack Compose).  
- **Domain Layer**: Handles business logic and use cases.  
- **Data Layer**: Manages data from API (using Ktor) and models.  
