package TheBestLab4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheBestPublisher extends Publisher {

    private Map<Readable, Integer> rating = new HashMap<>();

    public TheBestPublisher(String name){
        super(name);
    }


    private void survey(World world, Readable[] readables) {
        for (Readable readable : readables) {
            rating.put(readable, 0);
        }

        for (Country country : world.getCountries()) {
            if (country.isAnarchy()) {
                continue;
            }
            for (Person person : country.getPeople()) {
                for (Readable readable : person.whatYouBuy(readables)) {
                    rating.put(readable, rating.get(readable) + 1);
                }
            }
        }
    }

    public void publish(World world, Readable[] readables){
        survey(world, readables);
        Arrays.sort(readables, (o1, o2) -> rating.get(o1) - rating.get(o2));
        System.out.println("Издательская компания " + getName() + " представила данные по книжным предпочтениям людей со всего мира в " + world.getYear() + ":");
        for (int i = 0; i < Math.min(3, readables.length);i++){
            Readable readable = readables[i];
            if (i == 0){
                System.out.println("Абсолютным лидером продаж стала книга " + readable.read() + ".");
                System.out.println("Было продано ровно " + rating.get(readable) + " книг.");
            }
            else if (i == 1){
                System.out.println("Почетное второе место занимает книга " + readable.read() + ", проданная в количестве " + rating.get(readable) + " экземпляров.");
            } else {
                System.out.println("Тройку лидеров замыкает " + readable.read() + ".");
                System.out.println("Новинку купили более " + (rating.get(readable) - 1) + "раз.");
            }
        }
    }
}
