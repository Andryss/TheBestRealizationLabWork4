package TheBestLab4;

import java.util.HashMap;
import java.util.Map;

/**
 * Publisher, which invokes person's whatYouBuy method
 */
public class PurchasingPublisher extends Publisher {

    public PurchasingPublisher(String name) {
        super(name);
    }

    protected Readable[] invokePersonMethod(Person person, Readable[] readables){
        return person.whatYouBuy(readables);
    }

    protected void printResult(Readable[] readables, Map<Readable, Integer> rating) {
        for (int i = 0; i < Math.min(3, readables.length); i++) {
            Readable readable = readables[i];
            if (i == 0) {
                System.out.println("- Абсолютным лидером продаж стала книга " + readable.read() + ".");
                System.out.println("Было продано ровно " + rating.get(readable) / 1000 + " тыс. книг.");
            } else if (i == 1) {
                System.out.println("- Почетное второе место занимает книга " + readable.read() + ", \nпроданная в количестве " + rating.get(readable) / 1000 + " тыс. экземпляров.");
            } else {
                System.out.println("- Тройку лидеров замыкает " + readable.read() + ".");
                System.out.println("Новинку купили более " + (rating.get(readable) - 1) / 1000 + " тыс. раз.");
            }
        }
    }
}
