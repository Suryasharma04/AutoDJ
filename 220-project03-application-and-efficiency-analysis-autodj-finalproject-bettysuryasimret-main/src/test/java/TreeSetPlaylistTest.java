/*Authors of the Project: Betty Gebru, Surya Sharma, Simret Melak 
 *Purpose of the file: Tests the methods of TreeSet Playlist 
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import dragon.autodj.TreeSetPlaylist;
import dragon.autodj.Song;

public class TreeSetPlaylistTest {

    // Test the addSong and calculateDuration methods
    @Test
    public void testAddSongAndCalculateDuration() {
        TreeSetPlaylist playlist = new TreeSetPlaylist("TestPlaylist");
        assertTrue(playlist.isEmpty());
        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        assertEquals("TestPlaylist", playlist.getPlayListName());
        assertFalse(playlist.isEmpty());
        assertEquals(16.57, playlist.calculateDuration(), 0.01); 

        String expectedList = "Noon Fifteen - Annie's Song - 279267 - 0, " +
                              "Noon Fifteen - Dave Coulier - 375241 - 0, " +
                              "Noon Fifteen - Let You Roll - 339875 - 0, ";
        assertEquals(expectedList, playlist.listSongs());
    }

     // Test the removeSong method
    @Test
    public void testRemoveSong() {
        TreeSetPlaylist playlist = new TreeSetPlaylist("TestPlaylist");
        assertTrue(playlist.isEmpty());

        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.removeSong(song1.getTitle());
        assertFalse(playlist.isEmpty());

        String expectedListOne = "Noon Fifteen - Dave Coulier - 375241 - 0, Noon Fifteen - Let You Roll - 339875 - 0, ";
        assertEquals(expectedListOne, playlist.listSongs());

        playlist.removeSong(song2.getTitle());
        String expectedListTwo = "Noon Fifteen - Let You Roll - 339875 - 0, ";

        assertEquals(expectedListTwo, playlist.listSongs());
    }

     // Test the PlayNext method
    @Test
    public void testPlayNext() {
        TreeSetPlaylist playlist = new TreeSetPlaylist("TestPlaylist");

        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        String result = playlist.playNext();

        String expected = "Artist: Noon Fifteen, Title: Annie's Song, Duration: 279267, Play Count: 0";
        assertEquals(expected, result);

        assertFalse(playlist.isEmpty());

        String resultTwo = playlist.playNext();

        String expectedTwo = "Artist: Noon Fifteen, Title: Dave Coulier, Duration: 375241, Play Count: 0";

        assertEquals(expectedTwo, resultTwo);

        assertFalse(playlist.isEmpty());

        String expectedList = "Noon Fifteen - Let You Roll - 339875 - 0, ";
        assertEquals(expectedList, playlist.listSongs());
    }
}
