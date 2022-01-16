package TheBestLab4;

import java.util.Arrays;
import java.util.Objects;

/**
 * <p>Class World is a container for countries</p>
 * <p>World is a Singleton pattern</p>
 */
public class World {

    private int year;
    private Country[] countries;
    private static final World WORLD = new World();

    private World() {}

    /**
     * Method, which returns the only one World
     * @param year year we want to set
     * @param countries Country[] we want to set
     * @return the only one instance of World
     */
    public static World newInstance(int year, Country[] countries){
        WORLD.year = year;
        WORLD.countries = countries;
        return WORLD;
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
