/*Authors of the Project: Betty Gebru, Surya Sharma, Simret Melak 
 *Purpose of the file: Displays the efficiency charts of different implementations- Treeset and Hashset 
*/

import org.jfree.data.category.DefaultCategoryDataset;

import dragon.autodj.HashSetPlaylist;
import dragon.autodj.PlayList;
import dragon.autodj.Song;
import dragon.autodj.TreeSetPlaylist;
import dragon.autodj.data.SongDataIO;
import java.io.IOException;
import java.util.*;

public class PlaylistEfficiency {

    //Time taken to add a song to the playlist
    public static long timeAddSong(PlayList playlist, Song song){
        long start = System.nanoTime();
        playlist.addSong(song); 
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }
    
    //Time taken to remove a song to the playlist
    public static long timeRemove(PlayList playlist, Song song){
        playlist.addSong(song);
        long start = System.nanoTime();
        playlist.removeSong(song.getTitle()); 
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    //Time taken to play the next song in the playlist
    public static long timePlayNext(PlayList playlist, Song song){
        playlist.addSong(song);
        long start = System.nanoTime();
        playlist.playNext(); 
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    // The time taken to calculate the total duration of the playlist
    public static long timeDuration(PlayList playlist, Song song){
        playlist.addSong(song);
        long start = System.nanoTime();
        playlist.calculateDuration(); 
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    //The time taken to list all songs in the playlist
    public static long timeListSongs(PlayList playlist, Song song){
        playlist.addSong(song);
        long start = System.nanoTime();
        playlist.listSongs(); 
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static void main(String[] args) throws IOException {
        PlayList treePlaylist = new TreeSetPlaylist("TreeSet Playlist");
        PlayList hashPlaylist = new HashSetPlaylist("HashSet Playlist");

        String jsonFilePath = "src/test/resources/Localify_97k_Tracks.json";
        List<Song> allSongs = SongDataIO.buildSongListFromJsonFile(jsonFilePath);
        List<Song> songs = allSongs.subList(0, Math.min(5000, allSongs.size())); //only using the first 500 songs for plotting
    
        DefaultCategoryDataset addSongDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset removeSongDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset calculateDurationDataset = new DefaultCategoryDataset(); 
        DefaultCategoryDataset playNextDataset = new DefaultCategoryDataset(); 
        DefaultCategoryDataset listSongDataset = new DefaultCategoryDataset(); 
        
            //Using the data from methods above to add to the dataset in order to have graphs for comparison
            //For TreePlaylist
            for (Song song : songs) {
                long addSongTime = timeAddSong(treePlaylist, song);
                long removeSongTime = timeRemove(treePlaylist, song);
                long calculateDurationTime = timeDuration(treePlaylist, song);
                long playNextTime = timePlayNext(treePlaylist, song);
                long listSongTime = timeListSongs(treePlaylist, song);
        
                addSongDataset.addValue(addSongTime / 1e6, "TreeSet Playlist", song.getTitle());
                removeSongDataset.addValue(removeSongTime / 1e6, "TreeSet Playlist", song.getTitle());
                calculateDurationDataset.addValue(calculateDurationTime / 1e6, "TreeSet Playlist", song.getTitle());
                playNextDataset.addValue(playNextTime / 1e6, "TreeSet Playlist", song.getTitle());
                listSongDataset.addValue(listSongTime / 1e6, "TreeSet Playlist", song.getTitle());
            }
        
            //For HashPlaylist
            for (Song song : songs) {
                long addSongTime = timeAddSong(hashPlaylist, song);
                long removeSongTime = timeRemove(hashPlaylist, song);
                long calculateDurationTime = timeDuration(hashPlaylist, song);
                long playNextTime = timePlayNext(hashPlaylist, song);
                long listSongTime = timeListSongs(hashPlaylist, song);
        
                addSongDataset.addValue(addSongTime / 1e6, "HashSet Playlist", song.getTitle());
                removeSongDataset.addValue(removeSongTime / 1e6, "HashSet Playlist", song.getTitle());
                calculateDurationDataset.addValue(calculateDurationTime / 1e6, "HashSet Playlist", song.getTitle());
                playNextDataset.addValue(playNextTime / 1e6, "HashSet Playlist", song.getTitle());
                listSongDataset.addValue(listSongTime / 1e6, "HashSet Playlist", song.getTitle());
            }
        
            new EfficiencyChart("AddSong Efficiency", "Operation", "Time (ms)", addSongDataset);
            new EfficiencyChart("RemoveSong Efficiency", "Operation", "Time (ms)", removeSongDataset);
            new EfficiencyChart("Calculate Duration Efficiency", "Operation", "Time (ms)", calculateDurationDataset);
            new EfficiencyChart("Play Next Efficiency", "Operation", "Time (ms)", playNextDataset);
            new EfficiencyChart("List Song Efficiency", "Operation", "Time (ms)", listSongDataset);
        }
}


