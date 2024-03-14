package dragon.autodj;

/** Class: Song
 * Contains the main data about the song that will be added to the playlist. 
 */
public class Song  implements Comparable<Song>{
    private String artist;
    private String title;
    private int duration; 
    private int playCount; 
    private int spotifyPopularity;
    private double spotifyDanceability;
    private double spotifyEnergy;
    private double spotifyValence;

    public Song() {
        // Default constructor
    }
    //we can have getters, setters, and constructor 
    public Song(String artist, String title, int duration, int playCount){
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        this.playCount = playCount;
    }

    public Song(String string, String string2, double d) {
    }

    public String getArtist(){
        return this.artist;
    }

    public String getTitle(){
        return this.title;
    }
    
    public int getDuration(){
        return this.duration;
    }

    public int getPlayCount(){
        return this.playCount;
    }

    public int getSpotifyPopularity() {
        return spotifyPopularity;
    }
    public void setSpotifyPopularity(int spotifyPopularity) {
        this.spotifyPopularity = spotifyPopularity;
    }
    public double getSpotifyDanceability() {
        return spotifyDanceability;
    }
    public void setSpotifyDanceability(double spotifyDanceability) {
        this.spotifyDanceability = spotifyDanceability;
    }
    public double getSpotifyEnergy() {
        return spotifyEnergy;
    }
    public void setSpotifyEnergy(double spotifyEnergy) {
        this.spotifyEnergy = spotifyEnergy;
    }
    public double getSpotifyValence() {
        return spotifyValence;
    }
    public void setSpotifyValence(double spotifyValence) {
        this.spotifyValence = spotifyValence;
    }

 @Override
    public int compareTo(Song other) {
        int artistComparison = this.artist.compareTo(other.artist);
        if (artistComparison != 0) {
            return artistComparison;
        }
        // If the artist names are identical, compare by song title
        return this.title.compareTo(other.title);
    }
    
    
}