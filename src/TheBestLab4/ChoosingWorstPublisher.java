package TheBestLab4;

import java.util.Arrays;
import java.util.Map;

public class ChoosingWorstPublisher extends ChoosingPublisher {

    public ChoosingWorstPublisher(String name) {
        super(name);
    }

    @Override
    protected Readable invokePersonMethod(Person person, Readable[] readables) {
        return person.chooseTheWorst(readables);
    }

    @Override
    protected void printCountryResult(Country country, Readable[] readables, Map<Readable, Integer> rating) {
        Arrays.sort(readables, (o1, o2) -> rating.get(o2) - rating.get(o1));

        System.out.println("В стране " + country.getName() + ":");
        if (country.isAnarchy()) {
            System.out.println("*смеется по-анархически*");
            return;
        }
        for (int i = 0; i < Math.min(3, readables.length);i++){
            Readable readable = readables[i];
            if (i == 0){
                System.out.println("- Абсолютным лидером стала книга " + readable.read() + ".");
                System.out.println("Ее посчитали худшей " + rating.get(readable) + " опрошенных человек.");
            }
            else if (i == 1){
                System.out.println("- (Не) почетное второе место занимает книга " + readable.read() + ", \n,которую не предпочли " + rating.get(readable) + " опрошенных.");
            } else {
                System.out.println("- Тройку лидеров замыкает " + readable.read() + ".");
                System.out.println("Книгу выбрали " + (rating.get(readable) - 1) + " раз.");
            }
        }
    }
}
