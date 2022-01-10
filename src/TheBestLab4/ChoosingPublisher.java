package TheBestLab4;

import java.util.HashMap;
import java.util.Map;

public abstract class ChoosingPublisher extends Publisher {

    public ChoosingPublisher(String name){
        super(name);
    }

    protected abstract Readable invokePersonMethod(Person person, Readable[] readables);

    private Map<Readable, Integer> survey(Country country, Readable[] readables) {
        Map<Readable, Integer> rating = new HashMap<>();

        for (Readable readable : readables) {
            rating.put(readable, 0);
        }

        if (!country.isAnarchy()) {
            for (Person person : country.getPeople()) {
                Readable choice = invokePersonMethod(person, readables);
                if (choice != null) {
                    rating.put(choice, rating.get(choice) + 1);
                }
            }
        }

        return rating;
    }

    protected abstract void printCountryResult(Country country, Readable[] readables, Map<Readable, Integer> rating);

    public void publish(World world, Readable[] readables){
        System.out.println("Издательская компания " + getName() + " представила данные по книжным предпочтениям людей в разных странах в " + world.getYear() + " году.");

        for (Country country: world.getCountries()) {
            Map<Readable, Integer> rating = survey(country, readables);
            printCountryResult(country, readables, rating);
        }
    }
}
