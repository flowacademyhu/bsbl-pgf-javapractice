import java.util.ArrayList;

public class WordCounterWrapper implements Comparable<WordCounterWrapper> {

    private String word;
    private ArrayList<String> words;
    private int frequency;

    public WordCounterWrapper(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public WordCounterWrapper(ArrayList<String> words, int frequency) {
        this.words = words;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(WordCounterWrapper wordCounterWrapper) {
        if(this.frequency < wordCounterWrapper.frequency) {
            return 1;
        } else if(this.frequency == wordCounterWrapper.frequency) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        if(word != null) {
            return word + ": " +  frequency;
        } else {
            return frequency + ": " + words;
        }
    }
}
