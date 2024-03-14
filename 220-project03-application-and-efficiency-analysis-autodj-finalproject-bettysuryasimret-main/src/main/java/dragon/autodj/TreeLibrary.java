package dragon.autodj;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeLibrary implements Library {
    private TreeSet<Song> songs;

    public TreeLibrary() {
        this.songs = new TreeSet<>();
    }

    

    // Big O: O(n log n)
    // Explanation: The stream operation with map() is O(n), and collecting to a String with joining() is also O(n). 
    //However, TreeSet iteration itself is O(n log n) due to the tree traversal.
    @Override
    public String allSongs() {
        return songs.stream()
                    .map(song -> song.getArtist() + " - " + song.getTitle())
                    .collect(Collectors.joining(", "));
    }

    // Big O: O(log n)
    // Explanation: The contains() method in a TreeSet has a logarithmic time complexity as it's based on a Red-Black tree structure.
    @Override
    public String allInfo(Song song) {
        if (songs.contains(song)) {
            return String.format("Artist: %s, Title: %s, Duration: %d, Play Count: %d",
                                 song.getArtist(),
                                 song.getTitle(),
                                 song.getDuration(),
                                 song.getPlayCount());
        }
        return "Song not found in the library.";
    }

    // Big O: O(m log n)
    // Explanation: Adding each song to the TreeSet is O(log n), 
    //and this is done for each song in the collection, where m is the number of new songs.
    @Override
    public void AddSong(Collection<Song> newSongs) {
        songs.addAll(newSongs);
    }

    // Big O: O(m log n)
    // Explanation: Similar to AddSong, removing each song from the TreeSet is O(log n), 
    //and this is done for each song in the collection to remove.
    @Override
    public Collection<Song> removeSong(Collection<Song> songsToRemove) {
        songs.removeAll(songsToRemove);
        return songsToRemove;
    }

    // Big O: O(1)
    // Explanation: This method simply returns a reference to the songs TreeSet, 
    //which is a constant time operation.
    public TreeSet<Song> getSongList(){
        return songs;
    }

   
}