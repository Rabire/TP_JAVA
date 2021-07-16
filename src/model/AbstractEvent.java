package model;

public abstract class AbstractEvent {

    private String artist;
    private String projectName;
    private int year;


    protected AbstractEvent(String artist, String title, int year) {
        setArtist(artist);
        setProjectName(title);
        setYear(year);
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return getArtist() + ";" + getProjectName() + ";" + getYear();
    }
}
