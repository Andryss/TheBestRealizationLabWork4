package TheBestLab4;

public class Main {

    public static void main(String[] args){
        World world = new World(2022, Country.values());
        TheBestPublisher publisher = new TheBestPublisher("Компания \"Эксмо\"");
        publisher.publish(world, Book.values());
    }
}
