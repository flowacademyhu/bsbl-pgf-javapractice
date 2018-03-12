package book;

public class Book {

    private String author;
    private String title;
    private String publisher;
    private int datePublished;

    public Book(String author, String title, String publisher, int datePublished) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.datePublished = datePublished;
    }

    public Book() {
        author = "Angster Erzsébet";
        title = "Objektumorientált Tervezés és Programozás";
        publisher = "Kiskapu";
        datePublished = 2001;
    }

    protected final String getAuthor() {
        return author;
    }

    protected final void setAuthor(String author) {
        this.author = author;
    }

    protected final String getTitle() {
        return title;
    }

    protected final void setTitle(String title) {
        this.title = title;
    }

    protected final String getPublisher() {
        return publisher;
    }

    protected final void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected final int getDatePublished() {
        return datePublished;
    }

    protected final void setDatePublished(int datePublished) {
        this.datePublished = datePublished;
    }

    @Override
    public String toString() {
        return "Author: " + author + " Title: " + title + " Publisher: " + publisher + " Year published: " + datePublished;
    }
}
