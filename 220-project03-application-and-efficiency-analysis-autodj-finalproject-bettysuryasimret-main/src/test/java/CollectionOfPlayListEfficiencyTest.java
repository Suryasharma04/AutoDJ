import org.jfree.data.category.DefaultCategoryDataset;
import dragon.autodj.*;
import dragon.autodj.data.SongDataIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionOfPlayListEfficiencyTest {

    public static void main(String[] args) throws IOException {
        CollectionOfPlayList collection = new CollectionOfPlayListHashMap();
        String jsonFilePath = "src/test/resources/Localify_97k_Tracks.json";
        List<Song> songs = SongDataIO.buildSongListFromJsonFile(jsonFilePath);
        PlayList testPlaylist = new HashSetPlaylist("Test Playlist");

        DefaultCategoryDataset addPlayListDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset listPlayListDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset contentPlayListDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset removePlayListDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset randomPlayListDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset removeSongDataset = new DefaultCategoryDataset();

        // Assume a certain number of iterations for the test
        int iterations = 500;
        for (int i = 0; i < iterations; i++) {
            // Measure time for addNewPlayList
            long startTime = System.nanoTime();
            collection.addNewPlayList(testPlaylist);
            long endTime = System.nanoTime();
            addPlayListDataset.addValue((endTime - startTime) / 1e6, "Time (ms)", "Iteration " + i);

            // Measure time for listOfPlayList
            startTime = System.nanoTime();
            collection.listOfPlayList();
            endTime = System.nanoTime();
            listPlayListDataset.addValue((endTime - startTime) / 1e6, "Time (ms)", "Iteration " + i);

            // Measure time for contentOfParticularPlayList
            startTime = System.nanoTime();
            collection.contentOfParticularPlayList(testPlaylist);
            endTime = System.nanoTime();
            contentPlayListDataset.addValue((endTime - startTime) / 1e6, "Time (ms)", "Iteration " + i);

            // Measure time for removePlayList
            startTime = System.nanoTime();
            collection.removePlayList(testPlaylist);
            endTime = System.nanoTime();
            removePlayListDataset.addValue((endTime - startTime) / 1e6, "Time (ms)", "Iteration " + i);

            // Measure time for randomPlayList
            startTime = System.nanoTime();
            collection.randomPlayList("Random Playlist " + i, 600); // Example duration
            endTime = System.nanoTime();
            randomPlayListDataset.addValue((endTime - startTime) / 1e6, "Time (ms)", "Iteration " + i);

            // Measure time for removeSong
            startTime = System.nanoTime();
            collection.removeSong("Some Song Name");
            endTime = System.nanoTime();
            removeSongDataset.addValue((endTime - startTime) / 1e6, "Time (ms)", "Iteration " + i);
        }

        // Create efficiency charts for each method
        new EfficiencyChart("Add Playlist Efficiency", "Iteration", "Time (ms)", addPlayListDataset);
        new EfficiencyChart("List Playlist Efficiency", "Iteration", "Time (ms)", listPlayListDataset);
        new EfficiencyChart("Content of Playlist Efficiency", "Iteration", "Time (ms)", contentPlayListDataset);
        new EfficiencyChart("Remove Playlist Efficiency", "Iteration", "Time (ms)", removePlayListDataset);
        new EfficiencyChart("Random Playlist Efficiency", "Iteration", "Time (ms)", randomPlayListDataset);
        new EfficiencyChart("Remove Song Efficiency", "Iteration", "Time (ms)", removeSongDataset);
    }
}
