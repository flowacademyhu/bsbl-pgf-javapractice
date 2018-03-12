package shelf;
import java.util.*;
import book.*;


public class Shelf {

    public static void main(String[] args) {
        ArrayList<Book> bookArray = new ArrayList<Book>();
        putOnShelf(args, bookArray);

        for(int i = 0; i < bookArray.size(); i++) {
            System.out.println(bookArray.get(i));
        }

        System.out.println("Number of novels: " + Novel.getBookCount());
    }

    public static void putOnShelf(String[] args, ArrayList<Book> bookArray) {

        String[] arguments;

        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("Textbook")) {
                if(i == (args.length - 1)) {
                    Textbook tb = new Textbook();
                    bookArray.add(tb);
                    break;
                }

                arguments = args[i+1].split(",");
                if(arguments.length == 5) {
                    Textbook tb = new Textbook(arguments[0], arguments[1], arguments[2],
                            Integer.parseInt(arguments[3]), arguments[4]);
                    bookArray.add(tb);
                    i++;
                } else {
                    Textbook tb = new Textbook();
                    bookArray.add(tb);
                }
            } else if ((args[i].equals("Novel"))) {
                if(i == (args.length - 1)) {
                    Novel n = new Novel();
                    bookArray.add(n);
                    break;
                }

                arguments = args[i+1].split(",");
                if (arguments.length == 5) {
                    Novel n = new Novel(arguments[0], arguments[1], arguments[2],
                            Integer.parseInt(arguments[3]), arguments[4]);
                    bookArray.add(n);
                    i++;
                } else {
                    Novel n = new Novel();
                    bookArray.add(n);
                }
            }
        }
    }
}
