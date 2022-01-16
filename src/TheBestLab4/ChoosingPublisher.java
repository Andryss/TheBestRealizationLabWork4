package TheBestLab4;

import java.util.HashMap;
import java.util.Map;

/**
 * Publisher, which invokes person's choosing methods
 */
public abstract class ChoosingPublisher extends Publisher {

    public ChoosingPublisher(String name){
        super(name);
    }

    /**
     * Method, which invokes choosing method
     * @param person Person we need to survey
     * @param readables Readables, which participate in the survey
     * @return Readable the person choose
     */
    protected abstract Readable invokePersonMethod(Person person, Readable[] readables);

    protected Map<Readable, Integer> surveyCountry(Country country, Readable[] readables) {
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

    public void publish(World world, Readable[] readables, PublishOption option){
        if (option == PublishOption.IN_EACH_COUNTRY) {
            System.out.println("Издательская компания " + getName() + " представила данные по книжным предпочтениям людей в разных странах в " + world.getYear() + " году.");
            for (Country country: world.getCountries()) {
                Map<Readable, Integer> rating = surveyCountry(country, readables);
                printCountryResult(country, readables, rating);
            }
        } else if (option == PublishOption.ALL_AROUND_THE_WORLD) {
            System.out.println("Издательская компания " + getName() + " представила данные по книжным предпочтениям людей по всему миру в " + world.getYear() + " году:");
            Map<Readable, Integer> rating = surveyWorld(world, readables);
            printWorldResult(readables, rating);
        }
    }
}
