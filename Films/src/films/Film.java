package films;

public class Film {

    protected final String title;
    protected final String director;
    protected final int yearOfRelease;

    public Film(String title, String director, int yearOfRelease) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
    }

    public boolean nominateForOScar(int yearOfNomination) {
        if(yearOfNomination == yearOfRelease || (yearOfNomination  - 1) == yearOfRelease) {
            return Math.random() < 0.5;
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year of release=" + yearOfRelease +
                '}';
    }
}
