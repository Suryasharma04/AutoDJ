package dragon.autodj;

public interface PlayList {

    Object playlist = null;

    /**
     * Returns a string representation of all songs in the playlist.
     *
     * @return String representing all songs.
     */
    String listSongs();

    /**
     * Calculates the total duration of the playlist.
     *
     * @return Total duration of the playlist.
     */
    double calculateDuration();

    /**
     * Plays the next song in the playlist, removing it from the playlist.
     * 
     * @return Information about the song that was played.
     */
    String playNext();

    /**
     * Checks if the playlist is empty.
     *
     * @return true if the playlist is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Adds a song to the playlist.
     *
     * @param song The song to be added.
     */
    void addSong(Song song);

    /**
     * Removes a song from the playlist.
     *
     * @param song The song to be removed.
     */


    void removeSong(String songName);

    String getPlayListName();
    
}

