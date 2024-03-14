package dragon.autodj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionOfPlayListArrayList implements CollectionOfPlayList {
    private List<PlaylistDetails> playlists;
    private ListLibrary lib;

    public CollectionOfPlayListArrayList() {
        playlists = new ArrayList<>();
        lib = new ListLibrary();
    }

    private static class PlaylistDetails {
        PlayList playlist;
        String name;
        double duration;

        PlaylistDetails(PlayList playlist) {
            this.playlist = playlist;
            this.name = playlist.getPlayListName();
            this.duration = playlist.calculateDuration();
        }
    }

    // Big O: O(n)
    // Explanation: The method iterates over all the playlists, so the time complexity is linear to the number of playlists.
    @Override
    public String listOfPlayList() {
        StringBuilder sb = new StringBuilder();
        for (PlaylistDetails details : playlists) {
            sb.append(details.name).append(": ").append(details.duration).append(" minutes\n");
        }
        return sb.toString();
    }

    // Big O: O(n)
    // Explanation: In the worst case, the method iterates over all the playlists to find the matching one.
    @Override
    public String contentOfParticularPlayList(PlayList p) {
        for (PlaylistDetails details : playlists) {
            if (details.playlist.equals(p)) {
                return p.listSongs();
            }
        }
        return "This playlist is not found in the Collection of Playlists";
    }

   // Big O: O(n)
    // Explanation: The removeIf method internally may need to iterate over the entire list to find the playlist to remove.
    @Override
    public void removePlayList(PlayList p) {
        playlists.removeIf(details -> details.playlist.equals(p));
    }

    // Big O: O(1)
    // Explanation: Adding a new playlist to the ArrayList is an O(1) operation. However, it can become O(n) if a resize of the internal array is needed.
    @Override
    public void addNewPlayList(PlayList p) {
        playlists.add(new PlaylistDetails(p));
    }

    // Big O: O(n + m)
    // Explanation: Shuffling the list of all songs is O(n), and the subsequent for-loop is O(m), where m is the number of songs checked until the duration limit is reached.
    @Override
    public PlayList randomPlayList(String playlistName, double durationLimit) {
        PlayList newPlaylist = new HashSetPlaylist(playlistName);

        List<Song> allSongs = new ArrayList<>();
        for (PlaylistDetails details : playlists) {
            allSongs.add(details.playlist.listSongs());
        }

        Collections.shuffle(allSongs);

        double currentDuration = 0;
        for (Song song : allSongs) {
            if (currentDuration + song.getDuration() <= durationLimit) {
                newPlaylist.addSong(song);
                currentDuration += song.getDuration();
            }
            if (currentDuration >= durationLimit) {
                break;
            }
        }

        PlaylistDetails newPlaylistDetails = new PlaylistDetails(newPlaylist);
        playlists.add(newPlaylistDetails);
        return newPlaylist;
    }

    // Existing methods...

    // Big O: O(n * m)
    // Explanation: For each playlist (n), the removeSong operation is called which can be O(m) in the worst case, where m is the number of songs in a playlist.
    @Override
    public void removeSong(String songName) {
        for (PlaylistDetails details : playlists) {
            details.playlist.removeSong(songName);
        }
    }

    @Override
    public String addAllPlayList() {
        // Implementation is dependent on specific requirements
        throw new UnsupportedOperationException("Unimplemented method 'addAllPlayList'");
    }
}
