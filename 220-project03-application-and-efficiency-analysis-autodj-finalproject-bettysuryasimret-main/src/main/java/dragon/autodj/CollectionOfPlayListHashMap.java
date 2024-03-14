package dragon.autodj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionOfPlayListHashMap implements CollectionOfPlayList {
    Map<PlayList,List<String>> playlists;
    ListLibrary lib;

    public CollectionOfPlayListHashMap(){
        playlists = new HashMap<>();
        lib = new ListLibrary();
    }

    // Big O: O(n)
    // Explanation: Iterates over all entries in the HashMap. The time complexity is linear with respect to the number of playlists.
    @Override
    public String listOfPlayList() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<PlayList, List<String>> entry : playlists.entrySet()) {
            List<String> details = entry.getValue();
            if (details != null && details.size() >= 2) {
                String name = details.get(0); 
                String duration = details.get(1);
                sb.append(name).append(": ").append(duration).append(" minutes\n");
            }
        }
        return sb.toString();
    }

    // Big O: O(n)
    // Explanation: Iterates over all entries in the HashMap. The time complexity is linear with respect to the number of playlists.
    @Override
    public String contentOfParticularPlayList(PlayList p) {
        if(playlists.containsKey(p)){
            return p.listSongs();
        }

        return "This playlist is not found in the Collection of Playlists";
    }

    // Big O: O(1)
    // Explanation: Removal operation in a HashMap is generally O(1), assuming the hash function disperses elements properly among the buckets.
    @Override
    public void removePlayList(PlayList p) {
        playlists.remove(p);
    }

    // Big O: O(1)
    // Explanation: Adding a new entry to a HashMap is a constant time operation, again assuming good hash function dispersion.
    @Override
    public void addNewPlayList(PlayList p) {
        List<String> detail = new ArrayList<>();
        detail.add(p.getPlayListName());
        detail.add(String.valueOf(p.calculateDuration()));
        playlists.put(p, detail);
    }

    // Big O: O(n + m)
    // Explanation: Shuffling the list of all songs is O(n), and iterating through them in the for-loop is O(m), where m is the number of songs checked until the duration limit is reached.
    // @Override
    // public PlayList randomPlayList(String playlistName, double durationLimit) {
    //     PlayList newPlaylist = new HashSetPlaylist(playlistName);

    //     List<Song> allSongs = new ArrayList<>();
    //     for (PlaylistDetails details : playlists) {
    //         allSongs.add(details.playlist.listSongs());
    //     }

    //     Collections.shuffle(allSongs);

    //     double currentDuration = 0;
    //     for (Song song : allSongs) {
    //         if (currentDuration + song.getDuration() <= durationLimit) {
    //             newPlaylist.addSong(song);
    //             currentDuration += song.getDuration();
    //         }
    //         if (currentDuration >= durationLimit) {
    //             break;
    //         }
    //     }

    //     PlaylistDetails newPlaylistDetails = new PlaylistDetails();
    //     playlists.add(newPlaylistDetails);
    //     return newPlaylist;
    // }

    @Override
    public void removeSong(String songName) {
        for (Map.Entry<PlayList, List<String>> entry : playlists.entrySet()) {
            PlayList playlist = entry.getKey();
            playlist.removeSong(songName);
    }
}
    @Override
    public String addAllPlayList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAllPlayList'");
    }

    
}
