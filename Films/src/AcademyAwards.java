import films.*;

public class AcademyAwards {

    int yearOfGala;
    static Film[] nominatedFilms;
    static String founder = "Louis B. Mayer";
    static int counter = 0;

    public AcademyAwards(int yearOfGala, int counter) {
        this.yearOfGala = yearOfGala;
        this.nominatedFilms = new Film[counter];
    }

    public static void main(String[] args) {

        parseArgs(args);
        AcademyAwards oscars = new AcademyAwards(2018, counter);
        oscars.fillArray(args);
        oscars.printArray(nominatedFilms);
    }

    public static void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if(args[i]. equals("Film") || args[i].equals("ActionFilm")) {
                counter++;
            }
        }
    }

    public void fillArray(String[] args) {
        for (int i = 0, j = 0; i < args.length; i++, j++) {
            if (args[i].equals("Film")) {
                Film film = new Film(args[i + 1], args[i + 2], Integer.parseInt(args[i + 3]));
                nominatedFilms[j] = film;
                i += 3;
            } else if(args[i].equals("ActionFilm")){
                ActionFilm actionFilm = new ActionFilm(args[i + 1], args[i + 2], Integer.parseInt(args[i + 3]),
                        args[i + 4], Boolean.parseBoolean(args[i + 5]), Integer.parseInt(args[i + 6]));
                nominatedFilms[j] = actionFilm;
                i += 6;
            }
        }
    }

    public void printArray(Film[] films) {
        for (int i = 0; i < films.length; i++) {
            System.out.println(films[i]);
            System.out.println("This film won an Oscar: " + films[i].nominateForOScar(yearOfGala));
        }
    }
}
