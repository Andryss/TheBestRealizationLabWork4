package TheBestLab4;

public class Main {

    public static void main(String[] args){
        World world = new World(2022, Country.values());

        PurchasingPublisher publisher = new PurchasingPublisher("Компания \"Эксмо\"");
        // ChoosingBestPublisher publisher = new ChoosingBestPublisher("Компания \"Эксмо\"");
        // ChoosingWorstPublisher publisher = new ChoosingWorstPublisher("Компания \"Эксмо\"");

        Book harryPotter = new Book("Джоан Роулинг","Гарри Поттер",Genre.ADVENTURE,3,", повествующая о мальчике, который выжил");
        Book theStainlessSteelRat = new Book("Гарри Гаррисон", "Стальная крыса",Genre.SCIENCE_FICTION, 1, " - это серия научно-фантастических юмористических произведений Гарри Гаррисона (в основном, романов) о похождениях в отдалённом будущем ловкого галактического мошенника Джеймса Боливара Ди Гриза");
        Book[] books = {harryPotter, theStainlessSteelRat};

        publisher.publish(world, books);
    }
}
