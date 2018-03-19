package media;

public class Mp3 {

    private String performer;
    private String album;
    private String song;
    private int length;

    public Mp3(String performer, String album, String song, int length) {
        this.performer = performer;
        this.album = album;
        this.song = song;
        this.length = length;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "This song is by " + getPerformer() + " called " + getSong() + " from the album " + getAlbum() + " and it's length is " +
                getLength() + " seconds.";
    }
}
