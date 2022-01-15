package TheBestLab4;

import java.util.HashMap;
import java.util.Map;

public class PurchasingPublisher extends Publisher {

    public PurchasingPublisher(String name){
        super(name);
    }

    protected Map<Readable, Integer> surveyCountry(Country country, Readable[] readables) {
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

    protected void printResult(Readable[] readables, Map<Readable, Integer> rating) {
        for (int i = 0; i < Math.min(3, readables.length);i++){
            Readable readable = readables[i];
            if (i == 0){
                System.out.println("- Абсолютным лидером продаж стала книга " + readable.read() + ".");
                System.out.println("Было продано ровно " + rating.get(readable)/1000 + " тыс. книг.");
            }
            else if (i == 1){
                System.out.println("- Почетное второе место занимает книга " + readable.read() + ", \nпроданная в количестве " + rating.get(readable)/1000 + " тыс. экземпляров.");
            } else {
                System.out.println("- Тройку лидеров замыкает " + readable.read() + ".");
                System.out.println("Новинку купили более " + (rating.get(readable) - 1)/1000 + " тыс. раз.");
            }
        }
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
