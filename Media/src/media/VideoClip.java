package media;

public class VideoClip extends Mp3 {

    private float width;
    private float height;

    public VideoClip(String performer, String album, String song, int length, float width, float height) {
        super(performer, album, song, length);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + " The picture ratio is " + width / height + ".";
    }
}
