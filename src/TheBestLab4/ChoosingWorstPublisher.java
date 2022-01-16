package TheBestLab4;

import java.util.Map;

/**
 * Publisher, which invokes person's chooseTheWorst method
 */
public class ChoosingWorstPublisher extends ChoosingPublisher {

    public ChoosingWorstPublisher(String name) {
        super(name);
    }

    @Override
    protected Readable invokePersonMethod(Person person, Readable[] readables) {
        return person.chooseTheWorst(readables);
    }

    @Override
    protected void printResult(Readable[] readables, Map<Readable, Integer> rating) {
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
