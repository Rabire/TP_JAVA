package model;

public class OST extends AbstractEvent {

    private String filmTitle;

    public OST(String artist, String title, int year, String filmTitle) {
        super(artist, title, year);
        setFilmTitle(filmTitle);
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    @Override
    public String toString() {
        return "BO;" + super.toString() + ";" + getFilmTitle();
    }
}
