package dragon.autodj;

import java.util.Collection;
import java.util.List;

public interface Library {
        /**
         * @param
         * Returns        the Name of the Artist and the title of the Song
         */
        public String allSongs();

        /**
         * @param Song :
         *             Returns the Name of the Artist, the title, duration, playCount of
         *             the song
         */
        public String allInfo(Song song);

        /** @param Song : a Song object is added to the library */
        public void AddSong(Collection<Song> newSong); // can create a song object

        /** @param Song : Removes a song from the playlist */
        public Collection<Song> removeSong(Collection<Song> song);

        public Collection<Song> getSongList();

    }
    

