package films;

public class ActionFilm extends Film {

    private String nameOfHero;
    private boolean maleHero;
    private int bodyCount;

    public ActionFilm(String title, String director, int yearOfRelease, String nameOfHero, boolean maleHero, int bodyCount) {
        super(title, director, yearOfRelease);
        this.nameOfHero = nameOfHero;
        this.maleHero = maleHero;
        this.bodyCount = bodyCount;
    }

    public String getNameOfHero() {
        return nameOfHero;
    }

    public void setNameOfHero(String nameOfHero) {
        this.nameOfHero = nameOfHero;
    }

    public boolean isMaleHero() {
        return maleHero;
    }

    public void setMaleHero(boolean maleHero) {
        this.maleHero = maleHero;
    }

    public int getBodyCount() {
        return bodyCount;
    }

    public void setBodyCount(int bodyCount) {
        this.bodyCount = bodyCount;
    }

    @Override
    public String toString() {
        return "ActionFilm{" +
                "name of the hero='" + nameOfHero + '\'' +
                ", gender of the hero =" + (maleHero?("male"):("female")) +
                ", body count=" + bodyCount +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year of release=" + yearOfRelease +
                '}';
    }
}
