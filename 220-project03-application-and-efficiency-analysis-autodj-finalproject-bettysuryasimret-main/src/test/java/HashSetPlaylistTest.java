/*Authors of the Project: Betty Gebru, Surya Sharma, Simret Melak 
 *Purpose of the file: Tests the methods of Hashset Playlist 
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import dragon.autodj.HashSetPlaylist;
import dragon.autodj.Song;

public class HashSetPlaylistTest {

    // Test the listSongs method by adding songs to the playlist and checking if they are listed correctly
    @Test
    public void testListSongs() {
        HashSetPlaylist playlist = new HashSetPlaylist("TestPlaylist");

        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        String result = playlist.listSongs();

        assertTrue(result.contains("Noon Fifteen - Annie's Song - 279267 - 0"));
        assertTrue(result.contains("Noon Fifteen - Dave Coulier - 375241 - 0"));
        assertTrue(result.contains("Noon Fifteen - Let You Roll - 339875 - 0"));
    }

    // Test the playNext method by adding songs to the playlist and checking if they are played in order
    @Test
    public void testPlayNext() {
        HashSetPlaylist playlist = new HashSetPlaylist("TestPlaylist");

        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        assertFalse(playlist.isEmpty());

        String resultOne = playlist.playNext();
        assertFalse(playlist.listSongs().contains(resultOne));

        String resultTwo = playlist.playNext();
        assertFalse(playlist.listSongs().contains(resultTwo));

        String resultThree = playlist.playNext();
        assertFalse(playlist.listSongs().contains(resultThree));
    }

    // Test the isEmpty method by creating empty and non-empty playlists and checking their status
    @Test
    public void testIsEmpty() {
        HashSetPlaylist emptyPlaylist = new HashSetPlaylist("EmptyPlaylist");
        assertTrue(emptyPlaylist.isEmpty());

        Song song = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        HashSetPlaylist nonEmptyPlaylist = new HashSetPlaylist("NonEmptyPlaylist");
        nonEmptyPlaylist.addSong(song);
        assertFalse(nonEmptyPlaylist.isEmpty());
    }

    // Test the addSong method by adding songs to the playlist and checking if they are present
    @Test
    public void testAddSong() {
        HashSetPlaylist playlist = new HashSetPlaylist("TestPlaylist");

        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        assertTrue(playlist.listSongs().contains("Noon Fifteen - Annie's Song - 279267 - 0"));
        assertTrue(playlist.listSongs().contains("Noon Fifteen - Dave Coulier - 375241 - 0"));
        assertTrue(playlist.listSongs().contains("Noon Fifteen - Let You Roll - 339875 - 0"));
    }

    // Test the removeSong method by adding songs, removing one, and checking if it is no longer present
    @Test
    public void testRemoveSong() {
        HashSetPlaylist playlist = new HashSetPlaylist("TestPlaylist");

        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.removeSong("Annie's Song");

        assertFalse(playlist.listSongs().contains("Noon Fifteen - Annie's Song - 279267 - 0"));
        assertTrue(playlist.listSongs().contains("Noon Fifteen - Dave Coulier - 375241 - 0"));
        assertTrue(playlist.listSongs().contains("Noon Fifteen - Let You Roll - 339875 - 0"));
    }

    @Test
    public void testGetPlaylistName() {
        HashSetPlaylist playlist = new HashSetPlaylist("TestPlaylist");
        assertEquals("TestPlaylist", playlist.getPlayListName());
    }

    // Test the calculateDuration method by adding songs and checking if the total duration is calculated correctly
    @Test
    public void testCalculateDuration() {
        HashSetPlaylist playlist = new HashSetPlaylist("TestPlaylist");

        Song song1 = new Song("Noon Fifteen", "Annie's Song", 279267, 0);
        Song song2 = new Song("Noon Fifteen", "Dave Coulier", 375241, 0);
        Song song3 = new Song("Noon Fifteen", "Let You Roll", 339875, 0);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        assertEquals(16.57, playlist.calculateDuration(), 0.01); // Assuming duration is in milliseconds
    }
}


