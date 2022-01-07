package TheBestLab4;

public class World {

    private int year;
    private Country[] countries;

    public World(int year, Country[] countries){
        this.year = year;
        this.countries = countries;
    }

    public Country[] getCountries() {
        return countries;
    }

    public int getYear() {
        return year;
    }
}
