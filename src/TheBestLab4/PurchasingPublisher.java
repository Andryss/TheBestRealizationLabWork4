package TheBestLab4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PurchasingPublisher extends Publisher {

    public PurchasingPublisher(String name){
        super(name);
    }

    private Map<Readable, Integer> survey(Country country, Readable[] readables) {
        Map<Readable, Integer> rating = new HashMap<>();

        for (Readable readable : readables) {
            rating.put(readable, 0);
        }

        if (!country.isAnarchy()) {
            for (Person person : country.getPeople()) {
                for (Readable readable : person.whatYouBuy(readables)) {
                    rating.put(readable, rating.get(readable) + 1);
                }
            }
        }

        return rating;
    }

    private void printCountryResult(Country country, Readable[] readables, Map<Readable, Integer> rating) {
        Arrays.sort(readables, (o1, o2) -> rating.get(o2) - rating.get(o1));

        System.out.println("В стране " + country.getName() + ":");
        if (country.isAnarchy()) {
            System.out.println("*смеется по-анархически*");
            return;
        }
        for (int i = 0; i < Math.min(3, readables.length);i++){
            Readable readable = readables[i];
            if (i == 0){
                System.out.println("- Абсолютным лидером продаж стала книга " + readable.read() + ".");
                System.out.println("Было продано ровно " + rating.get(readable) + " книг.");
            }
            else if (i == 1){
                System.out.println("- Почетное второе место занимает книга " + readable.read() + ", \nпроданная в количестве " + rating.get(readable) + " экземпляров.");
            } else {
                System.out.println("- Тройку лидеров замыкает " + readable.read() + ".");
                System.out.println("Новинку купили более " + (rating.get(readable) - 1) + "раз.");
            }
        }
    }

    public void publish(World world, Readable[] readables){
        System.out.println("Издательская компания " + getName() + " представила данные по книжным предпочтениям людей в разных странах в " + world.getYear() + " году.");

        for (Country country: world.getCountries()) {
            Map<Readable, Integer> rating = survey(country, readables);
            printCountryResult(country, readables, rating);
        }
    }
}
