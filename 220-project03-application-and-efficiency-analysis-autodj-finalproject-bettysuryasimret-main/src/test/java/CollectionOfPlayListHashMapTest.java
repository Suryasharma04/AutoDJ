import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dragon.autodj.CollectionOfPlayListHashMap;
import dragon.autodj.HashSetPlaylist;
import dragon.autodj.PlayList;
import dragon.autodj.Song;
import dragon.autodj.TreeLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOfPlayListHashMapTest {

    private CollectionOfPlayListHashMap collection;
    private PlayList playlist;
    private Song song1, song2;

    @BeforeEach
    public void setUp() {
        collection = new CollectionOfPlayListHashMap();
        playlist = new HashSetPlaylist("Test Playlist");
        song1 = new Song("Artist1", "Title1", 300000, 5); // Duration in milliseconds
        song2 = new Song("Artist2", "Title2", 180000, 10);
        playlist.addSong(song1);
        playlist.addSong(song2);
    }

    @Test
    public void testAddNewPlayList() {
        assertTrue(collection.listOfPlayList().isEmpty());
        collection.addNewPlayList(playlist);
        assertFalse(collection.listOfPlayList().isEmpty());
    }

    @Test
    public void testRemovePlayList() {
        CollectionOfPlayListHashMap collection = new CollectionOfPlayListHashMap();
        PlayList playlist = new HashSetPlaylist("Test Playlist");
        collection.addNewPlayList(playlist);

        collection.removePlayList(playlist);

        String list = collection.listOfPlayList();
        assertFalse(list.contains("Test Playlist"));
    }

    @Test
    public void testListOfPlayList() {
        collection.addNewPlayList(playlist);
        String list = collection.listOfPlayList();
        assertNotNull(list, "listOfPlayList should not return null");
        assertTrue(list.contains("Test Playlist"));
    }

    @Test
    public void testContentOfParticularPlayList() {
        collection.addNewPlayList(playlist);
        String content = collection.contentOfParticularPlayList(playlist);
        assertNotNull(content);
        assertEquals(content, "Artist1 - Title1 - 300000 - 5, Artist2 - Title2 - 180000 - 10, ");
    }

    @Test
    public void testRemoveSong() {
        collection.addNewPlayList(playlist);
        collection.removeSong("Title1");
        String content = collection.contentOfParticularPlayList(playlist);
        assertFalse(content.contains("Title1"));
        assertEquals(content, "Artist2 - Title2 - 180000 - 10, ");
    }

    // @Test
    // public void testRandomPlayList() {
    //     CollectionOfPlayListHashMap collection = new CollectionOfPlayListHashMap();

    //     // Create some sample songs
    //     Song song1 = new Song("Song1", "Artist1", 120000, 5); // 2 minutes
    //     Song song2 = new Song("Song2", "Artist2", 180000, 10); // 3 minutes
    //     Song song3 = new Song("Song3", "Artist3", 240000, 15); // 4 minutes

    //     // Create a list of all songs
    //     List<Song> allSongs = new ArrayList<>();
    //     allSongs.add(song1);
    //     allSongs.add(song2);
    //     allSongs.add(song3);

    //     // Create a random playlist
    //     String playlistName = "RandomPlaylist";
    //     double maxDuration = 10.0;
    //     HashSetPlaylist randomPlaylist = (HashSetPlaylist) collection.randomPlayList(playlistName, maxDuration);

    //     assertNotNull(randomPlaylist);

    //     // Check if the duration of the new playlist is within the limit
    //     assertTrue(randomPlaylist.calculateDuration() <= maxDuration);

    //     // Check if songs were added to the playlist
    //     assertFalse(randomPlaylist.isEmpty());

    //     // Check if the playlist name matches
    //     assertEquals(playlistName, randomPlaylist.getPlayListName());

    //     // Additional check: Ensure that the songs in the playlist have valid durations
    //     for (Song song : randomPlaylist.getPlayListName()) {
    //         assertTrue(song.getDuration() > 0);
    //     }
    // }
   

}
