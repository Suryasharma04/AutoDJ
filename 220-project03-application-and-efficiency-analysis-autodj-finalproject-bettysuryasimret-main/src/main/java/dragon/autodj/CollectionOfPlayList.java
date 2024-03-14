package dragon.autodj;

public  interface CollectionOfPlayList {

    /**
     * @return String all playlist names and their durations
     * @param playlist
     * @param duration
     * 
     */

public String listOfPlayList();
    /**
     * return a string representing the contents of a particular playlist
     * @return String particular playlist names and their durations
     * 
     */
public String contentOfParticularPlayList(PlayList p); 

/**
 * remove a playlist
 */
public void removePlayList(PlayList p);


/**
 *  add a new empty playlist
 * @param playList
 */

public void addNewPlayList(PlayList p);
/**
 *  make a new random playList of specified duration
 * @return playList
 */

public PlayList randomPlayList(String playlistname,double duration);

/**
 *  remove a song from all playlists
 * 
 */
public void removeSong(String songName);

public String addAllPlayList() ;
      
}
