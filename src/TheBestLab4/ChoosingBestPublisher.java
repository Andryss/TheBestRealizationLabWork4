package TheBestLab4;

import java.util.Map;

/**
 * Publisher, which invokes person's chooseTheBest method
 */
public class ChoosingBestPublisher extends Publisher {

    public ChoosingBestPublisher(String name) {
        super(name);
    }

    @Override
    protected Readable[] invokePersonMethod(Person person, Readable[] readables) {
        return new Readable[]{person.chooseTheBest(readables)};
    }

    @Override
    protected void printResult(Readable[] readables, Map<Readable, Integer> rating) {
        for (int i = 0; i < Math.min(3, readables.length);i++){
            Readable readable = readables[i];
            if (i == 0){
                System.out.println("- Абсолютным лидером стала книга " + readable.read() + ".");
                System.out.println("Ее посчитали лучшей " + rating.get(readable) + " опрошенных человек.");
            }
            else if (i == 1){
                System.out.println("- Почетное второе место занимает книга " + readable.read() + ", \nкоторую предпочли " + rating.get(readable) + " опрошенных.");
            } else {
                System.out.println("- Тройку лидеров замыкает " + readable.read() + ".");
                System.out.println("Книгу выбрали " + (rating.get(readable) - 1) + " раз.");
            }
        }
    }
}
