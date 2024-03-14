import org.jfree.data.category.DefaultCategoryDataset;

import dragon.autodj.Library;
import dragon.autodj.ListLibrary;
import dragon.autodj.Song;
import dragon.autodj.TreeLibrary;
import dragon.autodj.data.SongDataIO;
import java.io.IOException;
import java.util.List;

public class LibraryEfficiencyTest {

    public static void main(String[] args) throws IOException {
        Library library = new ListLibrary();
        String jsonFilePath = "src/test/resources/Localify_97k_Tracks.json";
        List<Song> songs = SongDataIO.buildSongListFromJsonFile(jsonFilePath);
    
        DefaultCategoryDataset addSongDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset allSongsDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset removeSongDataset = new DefaultCategoryDataset();
    
        // Repeat the operations multiple times to get multiple data points
        for (int i = 0; i < 50; i++) { 
            // Measure time for adding songs
            long startTime = System.currentTimeMillis();
            library.AddSong(songs);
            long endTime = System.currentTimeMillis();
            addSongDataset.addValue(endTime - startTime, "Time (ms)", "AddSong " + i);
    
            // Measure time for retrieving all songs
            startTime = System.currentTimeMillis();
            library.allSongs();
            endTime = System.currentTimeMillis();
            allSongsDataset.addValue(endTime - startTime, "Time (ms)", "AllSongs " + i);
    
            // Measure time for removing songs
            startTime = System.currentTimeMillis();
            library.removeSong(songs.subList(0, 500)); // Remove half of the songs
            endTime = System.currentTimeMillis();
            removeSongDataset.addValue(endTime - startTime, "Time (ms)", "RemoveSong " + i);
        }
    
        new EfficiencyChart("AddSong Efficiency", "Operation", "Time (ms)", addSongDataset);
        new EfficiencyChart("AllSongs Efficiency", "Operation", "Time (ms)", allSongsDataset);
        new EfficiencyChart("RemoveSong Efficiency", "Operation", "Time (ms)", removeSongDataset);
    }
    
}
