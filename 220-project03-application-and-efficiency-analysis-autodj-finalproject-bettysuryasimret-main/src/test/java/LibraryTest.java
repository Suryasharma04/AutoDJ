
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dragon.autodj.Library;
import dragon.autodj.ListLibrary;
import dragon.autodj.Song;
import dragon.autodj.TreeLibrary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;


public class LibraryTest {

    @Test
    public void testAddSong() {
        Library library = new ListLibrary();
        Song song1 = new Song("Rihana", "Title1", 250, 0);
        Song song2 = new Song("Bob Marley", "Title2", 180, 0);
        Song song3 = new Song("Bob Marley", "One Love", 200, 0);

        library.AddSong(Arrays.asList(song1, song2, song3));

        String allSongs = library.allSongs();
        List<String> songsList = Arrays.asList(allSongs.split(", "));
        
        assertTrue(songsList.get(0).equals("Bob Marley - One Love"));
        assertTrue(songsList.get(1).equals("Bob Marley - Title2"));
        assertTrue(songsList.get(2).equals("Rihana - Title1"));
   
    }

    @Test
    public void testRemoveSong() {
        Library library = new ListLibrary();
        Song song1 = new Song("Rihana", "Title1", 250, 0);
        Song song2 = new Song("Bob Marley", "Title2", 200, 0);
        Song song3 = new Song("Bob Marley", "One Love", 180, 0);

        library.AddSong(Arrays.asList(song1, song2,song3));
        library.removeSong(Arrays.asList(song1,song2));

        String allSongs = library.allSongs();
        assertFalse(allSongs.contains("Rihana - Title1"));
        assertTrue(allSongs.contains("Bob Marley - One Love"));
    }

    @Test
    public void testAllInfoSongExists() {
        Library library = new ListLibrary();
        Song song = new Song("Artist", "Title", 200, 10);
        library.AddSong(Arrays.asList(song));

        String info = library.allInfo(song);
        assertEquals("Artist: Artist, Title: Title, Duration: 200, Play Count: 10", info);
    }

    @Test
    public void testAllInfoSongNotExists() {
        Library library = new ListLibrary();
        Song song = new Song("NonExistent", "NoTitle", 200, 5);

        String info = library.allInfo(song);
        assertEquals("Song not found in the library.", info);
    }
}
