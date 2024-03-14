package dragon.autodj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class ListLibrary implements Library {

    private List<Song> songList;

    public ListLibrary() {
        this.songList = new ArrayList<>();
    }

    // Big O: O(n log n)
    // Explanation: Collections.sort() typically has a time complexity of O(n log n). 
    //Iterating over the sorted list is O(n), so the dominant factor is the sorting operation.
    @Override
    public String allSongs() {
        StringBuilder builder = new StringBuilder();
        Collections.sort(songList);
        for (Song song : songList) {
            builder.append(song.getArtist()).append(" - ").append(song.getTitle()).append(", ");
        }
        return builder.toString();
    }

    // Big O: O(n)
    // Explanation: The contains() method of List has a linear time complexity as 
    //it potentially needs to iterate through the entire list.
    @Override
    public String allInfo(Song song) {
        if (!songList.contains(song)) {
            return "Song not found in the library.";
        }
        return "Artist: "+  song.getArtist() + ", Title: " + song.getTitle() + ", Duration: " + song.getDuration() + ", Play Count: " + song.getPlayCount();
    }

    // Big O: O(n)
    // Explanation: The addAll() method iterates over the collection of new songs and adds them to the songList. 
    //Its complexity is linear with respect to the number of new songs.
    @Override
    public void AddSong(Collection<Song> newSongs) {
        songList.addAll(newSongs);
    }

    // Big O: O(n*m)
    // Explanation: The removeAll() method has to iterate over the songsToRemove and for each one, 
    //potentially scan the entire songList to find and remove it. n is the number of songs in songList and m is the number of songs to remove.
    
    @Override
    public Collection<Song> removeSong(Collection<Song> songsToRemove) {
        songList.removeAll(songsToRemove);
        return songsToRemove;
    }

    // Big O: O(1)
    // Explanation: This method simply returns a reference to the songList, which is a constant time operation.
    @Override
    public List<Song> getSongList(){
        return songList;
    }
}



