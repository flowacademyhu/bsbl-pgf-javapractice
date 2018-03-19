package player;

import media.*;

public class Winamp {

    public static void main(String[] args) {
        Winamp winamp = new Winamp(Integer.parseInt(args[0]));
        winamp.add(new Mp3("Phil Collins", "Face Value", "In the Air Tonight", 334));
        winamp.add(new VideoClip("DJ Snake, Lil Jon", "Single", "Turn Down for What", 230, 1920, 1080));
        winamp.add(new Mp3("George Michael", "Make It Big", "Careless Whisper", 390));
        winamp.add(new VideoClip("Nine Inch Nails", "The Downward Spiral", "Closer", 373, 1920, 1080));
        winamp.add(new Mp3("The Glitch Mob", "Remix", "Seven Nation Army", 257));

        System.out.println(winamp.averageLength(winamp.songs));
        winamp.listSongs(winamp.songs);
    }

    private Mp3[] songs;
    private int listLength;
    private int songCount = 0;

    public Winamp(int listLength) {
        this.songs = new Mp3[listLength];
    }

    public void add(Mp3 song) {
        if(songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Can't put more songs into the player.");
        }
    }

    public Mp3 inquire(int i) {
        return songs[i];
    }

    public void info(Mp3 song) {
        System.out.println(song);
    }

    public float averageLength(Mp3[] songs) {
        float sum = 0;
        for(int i = 0; i < songs.length; i++) {
            sum += inquire(i).getLength();
        }
        return sum / songs.length;
    }

    public void listSongs(Mp3[] songs) {
        for(int i = 0; i < songs.length; i++) {
            info(inquire(i));
        }
    }

    public int getListLength() {
        return listLength;
    }

    public void setListLength(int listLength) {
        this.listLength = listLength;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}
