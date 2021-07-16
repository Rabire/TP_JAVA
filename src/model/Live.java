package model;

public class Live extends AbstractEvent {

    private String location;

    public Live(String artist, String title, int year, String location) {
        super(artist, title, year);
        setLocation(location);
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Live;" + super.toString() + ";" + getLocation();
    }
}
