package shelf;
import java.util.*;
import book.*;


public class Shelf {

    private String[] arguments;
    private static ArrayList<Book> bookArray = new ArrayList<>();
    private int i;

    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        shelf.setArgs(args);
        shelf.putOnShelf();
        shelf.printBooks();
    }

    private void printBooks() {
        for (Book book : bookArray) {
            System.out.println(book);
        }
    }

    private void setArgs(String[] array) {
        arguments = array;
    }


    private boolean isTextbook(){
        return arguments[i].equals("Textbook");
    }

    private boolean isNovel(){
        return arguments[i].equals("Novel");
    }

    private HashMap<String, Object> getBookOptions(String[] bookAttributes) {
        HashMap<String, Object> bookMap = new HashMap<>();
        bookMap.put("author", bookAttributes[0]);
        bookMap.put("title", bookAttributes[1]);
        bookMap.put("publisher", bookAttributes[2]);
        bookMap.put("datePublished", Integer.parseInt(bookAttributes[3]));
        if(isTextbook()) {
            bookMap.put("subject", bookAttributes[4]);
        } else {
            bookMap.put("genre", bookAttributes[4]);
        }
        return bookMap;
    }

    private void createTextbook(HashMap<String, Object> bookAttributes) {
        Textbook textbook = new Textbook(
                (String)bookAttributes.get("author"),
                (String)bookAttributes.get("title"),
                (String)bookAttributes.get("publisher"),
                (int)bookAttributes.get("datePublished"),
                (String)bookAttributes.get("subject")
        );
        bookArray.add(textbook);
        i++;
    }

    private void createNovel(HashMap<String, Object> bookAttributes) {
        Novel novel = new Novel(
                (String)bookAttributes.get("author"),
                (String)bookAttributes.get("title"),
                (String)bookAttributes.get("publisher"),
                (int)bookAttributes.get("datePublished"),
                (String)bookAttributes.get("genre")
        );
        bookArray.add(novel);
        i++;
    }

    private void createDefaultTextbook() {
        Textbook tb = new Textbook();
        bookArray.add(tb);
    }

    private void createDefaultBook() {
        Novel n = new Novel();
        bookArray.add(n);
    }

    private void putTextbook() {
        HashMap<String, Object> bookAttributes;
        if(isIteratorAtEnd()) {
            createDefaultTextbook();
        } else {
            if(containsComma()) {
                bookAttributes = getBookOptions(arguments[i+1].split(","));
                createTextbook(bookAttributes);
            } else if (isIteratorNotAtEnd()){
                createDefaultTextbook();
            }
        }
    }

    private void putNovel() {
        HashMap<String, Object> bookAttributes;
        if(isIteratorAtEnd()) {
            createDefaultBook();
        } else {
            if(containsComma()) {
                bookAttributes = getBookOptions(arguments[i+1].split(","));
                createNovel(bookAttributes);
            } else if (isIteratorNotAtEnd()){
                createDefaultBook();
            }
        }
    }

    private boolean containsComma() {
        return arguments[i+1].contains(",");
    }

    private boolean isIteratorAtEnd() {
        return i == (arguments.length - 1);
    }

    private boolean isIteratorNotAtEnd() {
        return i != (arguments.length - 1);
    }

    private void putOnShelf() {
        while(i < arguments.length) {
            if(isTextbook()) {
                putTextbook();
            } else if (isNovel()) {
                putNovel();
            }
            i++;
        }
    }
}
