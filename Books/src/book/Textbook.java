package book;

public class Textbook extends Book {

    private String subject;

    public Textbook(String author, String title, String publisher, int datePublished, String subject) {
        super(author, title, publisher, datePublished);
        this.subject = subject;
    }

    public Textbook() {
        super();
        subject = "Programozás 1";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Textbook, Subject: " + subject + " " + super.toString();
    }
}
