package TheBestLab4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Publisher {

    private String name;

    public Publisher(String name){
        this.name = name;
    }

    abstract public void publish(World world, Readable[] readables, PublishOption option);

    protected abstract Map<Readable, Integer> surveyCountry(Country country, Readable[] readables);

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

    protected abstract void printResult(Readable[] readables, Map<Readable, Integer> rating);

    protected void printCountryResult(Country country, Readable[] readables, Map<Readable, Integer> rating) {
        Arrays.sort(readables, (o1, o2) -> rating.get(o2) - rating.get(o1));

        System.out.println("В стране " + country.getName() + ":");
        if (country.isAnarchy()) {
            System.out.println("*смеется по-анархически*");
            return;
        }
        printResult(readables, rating);
    }

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
