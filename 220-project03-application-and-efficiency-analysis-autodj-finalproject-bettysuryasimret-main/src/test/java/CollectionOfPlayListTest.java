import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import dragon.autodj.CollectionOfPlayListHashMap;
import dragon.autodj.HashSetPlaylist;
import dragon.autodj.Library;
import dragon.autodj.PlayList;
import dragon.autodj.Song;
import dragon.autodj.TreeLibrary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CollectionOfPlayListTest {
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
        assertEquals(content,"Artist1 - Title1 - 300000 - 5, Artist2 - Title2 - 180000 - 10, ") ;
    }

    @Test
    public void testRemoveSong() {
        collection.addNewPlayList(playlist);
        collection.removeSong("Title1");
        String content = collection.contentOfParticularPlayList(playlist);
        assertFalse(content.contains("Title1"));
        assertEquals(content,"Artist2 - Title2 - 180000 - 10, ") ;
    }

    // Note: Implementing a test for randomPlayList can be tricky due to the random nature of the method.
    // However, you can still test if it creates a playlist and adds songs without exceeding the duration limit.
    @Test
    public void testRandomPlayList() {
        List<Song> controlledSongs = Arrays.asList(
            new Song("Artist1", "Title1", 120000, 5), // 2 minutes
            new Song("Artist2", "Title2", 180000, 10), // 3 minutes
            new Song("Artist3", "Title3", 240000, 15)  // 4 minutes
        );
        TreeLibrary lib = new TreeLibrary();
        lib.AddSong(controlledSongs);
        assertEquals(lib.getSongList().size(),3);
        String[] songsList = lib.allSongs().split(", ");
        assertEquals(songsList.length, 3);

        // Assume duration limit is in milliseconds
        PlayList randomPlaylist1 = collection.randomPlayList("Random Playlist1", 600000); // 10 minutes
        PlayList randomPlaylist2 = collection.randomPlayList("Random Playlist2", 6); // 6 minutes
        assertNotEquals("This playlist is not found in the Collection of Playlists",collection.contentOfParticularPlayList(randomPlaylist2));
        assertEquals("",collection.contentOfParticularPlayList(randomPlaylist2));
      
        
    }
    
}
