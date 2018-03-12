package book;

public class Novel extends Book {

    String genre;
    static int bookCount = 0;

    public Novel(String author, String title, String publisher, int datePublished, String genre) {
        super(author, title, publisher, datePublished);
        this.genre = genre;
        bookCount++;
    }

    public Novel() {
        super();
        genre = "ifjúsági";
        bookCount++;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static int getBookCount() {
        return bookCount;
    }

    @Override
    public String toString() {
        return "Novel Genre: " + genre + " " + super.toString();

    }
}
