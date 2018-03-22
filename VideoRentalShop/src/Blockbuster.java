import java.util.*;

public class Blockbuster {

    Map<String, Rentable> videoMap = new HashMap<>();
    Map<String, Rentable> educationalVideoMap = new HashMap<>();

    public Blockbuster() {
    }

    public void addVideo(Video video) {
        if(video.getClass() == EducationalVideo.class) {
            educationalVideoMap.put(video.getTitle(), video);
        } else {
            videoMap.put(video.getTitle(), video);
        }
    }

    public Rentable search(String title, boolean isEducational) throws NotFoundException {
        if(isEducational && educationalVideoMap.containsKey(title)) {
            return educationalVideoMap.get(title);
        } else if (!isEducational && videoMap.containsKey(title)) {
            return videoMap.get(title);
        } else {
            throw new NotFoundException("We don't have this tape.");
        }
    }
}
