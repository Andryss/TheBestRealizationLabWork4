package TheBestLab4;

import java.util.Arrays;
import java.util.Objects;

public class World {

    private int year;
    private Country[] countries;

    public World(int year, Country[] countries){
        this.year = year;
        this.countries = validCountries(countries);
    }

    private Country[] validCountries(Country[] countries){
        int numberOfCountries = 0;
        for (Country country: countries){
            if (country != null){
                numberOfCountries++;
            }
        }
        Country[] thisCountries = new Country[numberOfCountries];
        int pointer = 0;
        for (Country country: countries){
            if (country != null){
                thisCountries[pointer] = country;
                pointer++;
            }
        }
        return thisCountries;
    }

    public Country[] getCountries() {
        return countries;
    }

    public int getYear() {
        return year;
    }

    public String toString(){
        return "Мир " + getYear() + " года, включающий в себя " + countries.length + " различных стран";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        World world = (World) o;
        return year == world.year && Arrays.equals(countries, world.countries);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(year);
        result = 31 * result + Arrays.hashCode(countries);
        return result;
    }
}
