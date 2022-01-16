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
     * Method that determines the way publisher will make a survey
     * @param person Person who we will ask
     * @param readables Readables that are allowed for him to buy/choose
     */
    abstract protected Readable[] invokePersonMethod(Person person, Readable[] readables);

    /**
     * Main method, which contains the main logic of class (only one public method)
     * @param world World with countries
     * @param readables Readables, which participate in the survey
     * @param option see PublishOption inner enum
     */
    public void publish(World world, Readable[] readables, PublishOption option){
        if (option == PublishOption.IN_EACH_COUNTRY) {
            System.out.println("Издательская компания " + getName() + " представила данные по книжным предпочтениям людей в разных странах в " + world.getYear() + " году.");
            for (Country country : world.getCountries()) {
                Map<Readable, Integer> rating = surveyCountry(country, readables);
                printCountryResult(country, readables, rating);
            }
        } else if (option == PublishOption.ALL_AROUND_THE_WORLD) {
            System.out.println("Издательская компания " + getName() + " представила данные по книжным предпочтениям людей по всему миру в " + world.getYear() + " году:");
            Map<Readable, Integer> rating = surveyWorld(world, readables);
            printWorldResult(readables, rating);
        }
    }

    /**
     * Method, which survey one Country
     * @param country Country we need to survey
     * @param readables Readables, which participate in the survey
     * @return Map with rating
     */
    protected Map<Readable, Integer> surveyCountry(Country country, Readable[] readables) {
        Map<Readable, Integer> rating = new HashMap<>();

        for (Readable readable : readables) {
            rating.put(readable, 0);
        }

        for (Person person : country.getPeople()) {
            Readable[] readables1 = invokePersonMethod(person, readables);
            if (readables1.length != 0 && readables1[0] != null) {
                for (Readable readable : readables1) {
                    rating.put(readable, rating.get(readable) + 1);
                }
            }
        }


        return rating;
    }

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
