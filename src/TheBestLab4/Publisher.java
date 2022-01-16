package TheBestLab4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Publisher class asks persons about their preferences
 */
public abstract class Publisher {

    private String name;

    public Publisher(String name){
        this.name = name;
    }

    /**
     * Main method, which contains the main logic of class (only one public method)
     * @param world World with countries
     * @param readables Readables, which participate in the survey
     * @param option see PublishOption inner enum
     */
    abstract public void publish(World world, Readable[] readables, PublishOption option);

    /**
     * Method, which survey one Country
     * @param country Country we need to survey
     * @param readables Readables, which participate in the survey
     * @return Map with rating
     */
    protected abstract Map<Readable, Integer> surveyCountry(Country country, Readable[] readables);

    /**
     * Method, which survey one World
     * @param world World we need to survey
     * @param readables Readables, which participate in the survey
     * @return Map with rating
     */
    protected Map<Readable, Integer> surveyWorld(World world, Readable[] readables) {
        Map<Readable, Integer> ratingWorld = new HashMap<>();

        for (Readable readable : readables) {
            ratingWorld.put(readable, 0);
        }

        for (Country country : world.getCountries()) {
            Map<Readable, Integer> ratingLocal = surveyCountry(country, readables);
            for (Readable readable : readables) {
                ratingWorld.put(readable, ratingWorld.get(readable) + ratingLocal.get(readable));
            }
        }

        return ratingWorld;
    }

    /**
     * Method, which print results based on the rating
     * @param readables Readables, which participate in the survey
     * @param rating Rating we need to print
     */
    protected abstract void printResult(Readable[] readables, Map<Readable, Integer> rating);

    /**
     * Method, which print results in one Country (use printResult method)
     * @param country this Country
     * @param readables Readables, which participate in the survey
     * @param rating Rating we need to print
     */
    protected void printCountryResult(Country country, Readable[] readables, Map<Readable, Integer> rating) {
        Arrays.sort(readables, (o1, o2) -> rating.get(o2) - rating.get(o1));

        if (country.isAnarchy()) {
            return;
        }
        System.out.println("В стране " + country.getName() + ":");
        printResult(readables, rating);
    }

    /**
     * Method, which print results in one World (use printCountryResult method)
     * @param readables Readables, which participate in the survey
     * @param rating Rating we need to print
     */
    protected void printWorldResult(Readable[] readables, Map<Readable, Integer> rating) {
        Arrays.sort(readables, (o1, o2) -> rating.get(o2) - rating.get(o1));

        printResult(readables, rating);
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return getClass().getName() + " " + name;
    }

    enum PublishOption {
        IN_EACH_COUNTRY,
        ALL_AROUND_THE_WORLD
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
