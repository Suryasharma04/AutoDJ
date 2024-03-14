
/*Authors of the Project: Betty Gebru, Surya Sharma, Simret Melak 
 *Purpose of the file: Implements the methods of Playlist using TreeSet
*/

package dragon.autodj;
import java.util.*;


public class TreeSetPlaylist implements PlayList {
    private TreeSet<Song> treePlaylist;
    private String playlistName;
    private double totalDuration;
    private Library lib;

    public TreeSetPlaylist(String playlistName){
        this.treePlaylist = new TreeSet<>();
        this.playlistName = playlistName;
        this.totalDuration = 0;
        lib = new ListLibrary();
    }


    //Time Complexity: O(1)
   // Big O: O(n)
   // Explanation: Iterates over all songs in the TreeSet, so the time complexity is linear with respect to the number of songs.

    @Override
    public String listSongs() {
        StringBuilder listOfAllSongs = new StringBuilder();
        for (Song song : treePlaylist) {
            listOfAllSongs.append(song.getArtist()).append(" - ")
                    .append(song.getTitle()).append(" - ")
                    .append(song.getDuration()).append(" - ")
                    .append(song.getPlayCount()).append(", ");
        }
        return listOfAllSongs.toString();
    }

    // Expected Big O: O(log n) // turns out it is O(n^2)
    // Explanation: Accessing the first element in a TreeSet is O(log n) due to the tree traversal. 
    //Removing that element is also O(log n).
    @Override
    public String playNext() {
        if(treePlaylist.isEmpty()){
            return "Empty Playlist"; 
        }
        Song temp = treePlaylist.first();

        if(temp == null){ 
            return "No Song in the Playlist"; 
        }

        treePlaylist.remove(temp);
        return lib.allInfo(temp);
    }

    // Big O: O(1)
    // Explanation: Checking if the TreeSet is empty is a constant time operation.
    @Override
    public boolean isEmpty() {
        return treePlaylist.isEmpty();
    }

    // Big O: O(log n)
    // Explanation: Adding an element to a TreeSet is O(log n), assuming the tree remains balanced. 
    // The lib.AddSong(treePlaylist) line might change this complexity depending on its implementation.
    @Override
    public void addSong(Song song) {
        treePlaylist.add(song);
        lib.AddSong(treePlaylist);
        totalDuration += song.getDuration() / 1000.0;
    }

    // Big O: O(n)
    // Explanation: In the worst case, 
    //it might have to iterate through all songs to find the one to remove, making it O(n).
    @Override
    public void removeSong(String songName) {
        Iterator<Song> iterator = treePlaylist.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equals(songName)) {
                iterator.remove();
                totalDuration-=song.getDuration();
                break;
            }
        }
    }

    public String getPlayListName() {
        return playlistName;
    }

    // Big O: O(1)
    // Explanation: This method simply recalculates and returns a pre-computed value, 
    //which is a constant time operation.
    @Override
    public double calculateDuration() {
       totalDuration = totalDuration / 60.0;
       return totalDuration;
    }


   

   
}