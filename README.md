# Auto DJ

(NOTE: This project was part of a group effort for our Intro to Data Structures course, where I collaborated with my friends Betty Gebru and Simret Melak under the guidance of Professor Toby Dragon at Ithaca College, NY)

Our main goal was to test the efficiency of various data structures through implementation. We designed three interfaces: Playlist, Library, and CollectionsOfPlaylist, each with two different implementations using different data structures. To facilitate this, we utilized the Song.java file to create Song objects and worked with a provided JSON file containing a dataset of nearly 1 million songs, although we only analyzed a subset of a few thousand songs.
This program will maintain a comprehensive library of authorized music and generate playlists for automated playback during periods when a human DJ isn't available. The music library will include essential information for each song, such as Artist, Title, Duration, and Play count (indicating how many times a song has been played). Playlists will be ordered collections of these songs, each with a unique name. Users will have the flexibility to create multiple playlists. To keep the listening experience fresh, we've implemented a rule to prevent playlist repetition. As songs are played from a playlist, they're dynamically removed to ensure that no song is repeated within the same playlist.

For a detailed analysis of each data structure's performance across different methods, please refer to the following link:
[Application and efficiency Analysis file](https://docs.google.com/document/d/1egahvNERzdp_3jHk-K4PE88PXJQH6IOykll2I7NoYi4/edit)


