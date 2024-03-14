
/*Authors of the Project: Betty Gebru, Surya Sharma, Simret Melak 
 *Purpose of the file: Implements the methods of Playlist using HashSet
*/


package dragon.autodj;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetPlaylist implements PlayList {
    private HashSet<Song> hashSetPlaylist;
    private String playlistName;
    private double totalDuration;
    private Library lib;
    int numOfSongs;

    public HashSetPlaylist(String playlistName) {
        this.hashSetPlaylist = new HashSet<>();
        this.playlistName = playlistName;
        this.totalDuration = 0;
        lib = new ListLibrary();
        numOfSongs=0;
    }

    //Time Complexity: O(1)
    // Big O: O(n)
    // Explanation: Iterates over all songs in the HashSet, so the time complexity is linear with respect to the number of songs.
    @Override
    public static String listSongs() {
        StringBuilder listOfAllSongs = new StringBuilder();
        for (Song song : hashSetPlaylist) {
            listOfAllSongs.append(song.getArtist()).append(" - ")
                    .append(song.getTitle()).append(" - ")
                    .append(song.getDuration()).append(" - ")
                    .append(song.getPlayCount()).append(", ");
        }
        return listOfAllSongs.toString();
    }


    //Time Complexity: O(n) //turns out to be O(n^2)
    // Big O: O(1) on average
    // Explanation: HashSet provides constant time performance for basic operations. 
    // However, the iterator.next() and iterator.remove() can be considered O(1) as they are accessing and removing a single element.
    @Override
    public String playNext() {
    if (hashSetPlaylist.isEmpty()) {
        return "Empty Playlist";
    }

    Iterator<Song> iterator = hashSetPlaylist.iterator();
    if (!iterator.hasNext()) {
        return "No Song in the Playlist";
    }

    Song temp = iterator.next();
    iterator.remove(); 
    return lib.allInfo(temp);
}

    // Big O: O(1)
    // Explanation: Checking if the HashSet is empty is a constant time operation.
    @Override
    public boolean isEmpty() {
        return hashSetPlaylist.isEmpty();
    }

    // Big O: O(1) on average
    // Explanation: Adding an element to a HashSet is a constant time operation assuming good hash function dispersion.
    // Note: The lib.AddSong(hashSetPlaylist) line might change this complexity depending on its implementation.
    @Override
    public void addSong(Song song) {
        hashSetPlaylist.add(song);
        lib.AddSong(hashSetPlaylist);
        totalDuration += song.getDuration() / 1000.0;
    }

    
    // Big O: O(n)
    // Explanation: In the worst case, it might have to iterate through all songs to find the one to remove.
    @Override
    public void removeSong(String songName) {
        // Using an iterator to avoid ConcurrentModificationException
        Iterator<Song> iterator = hashSetPlaylist.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equals(songName)) {
                iterator.remove(); 
                numOfSongs--;
                totalDuration-= song.getDuration();
                break; 
            }
        }
}

    public String getPlayListName() {
        return playlistName;
    }

    // Big O: O(1)
    // Explanation: Simply returns a pre-calculated value, which is a constant time operation.
    @Override
    public double calculateDuration() {
        return totalDuration / 60.0;
    }

    public int getNumOfSongs(){
        return numOfSongs;
    }
}
