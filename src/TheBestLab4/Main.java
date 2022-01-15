package TheBestLab4;

public class Main {

    public static void main(String[] args){
        PurchasingPublisher publisher = new PurchasingPublisher("Компания \"Эксмо\"");
        // ChoosingBestPublisher publisher = new ChoosingBestPublisher("Компания \"Эксмо\"");
        // ChoosingWorstPublisher publisher = new ChoosingWorstPublisher("Компания \"Эксмо\"");

        Book harryPotter = new Book("Джоан Роулинг","Гарри Поттер",Genre.ADVENTURE,"повествует о мальчике, который выжил");
        Book theStainlessSteelRat = new Book("Гарри Гаррисон","Стальная крыса",Genre.SCIENCE_FICTION,"это серия научно-фантастических юмористических произведений Гарри Гаррисона (в основном, романов) о похождениях в отдалённом будущем ловкого галактического мошенника Джеймса Боливара Ди Гриза");
        Book firstPlace = new Book("Михаил Лабковский","Хочу и буду",Genre.PSYCHOLOGICAL);
        Book secondPlace = new Book("Майк Омер","Внутри убийцы",Genre.DETECTIVE,"криминальный психолог-женщина расследует череду жестоких преступлений");
        Book thirdPlace = new Book("Виктор Пелевин","Transhumanism inc.",Genre.NOVEL);
        Book[] books = {harryPotter, theStainlessSteelRat, firstPlace, secondPlace, thirdPlace};

        Country RUSSIA = Country.CountryFactory.initializationRandom("Россия", (int) (5e5));
        Country SWEDEN = Country.CountryFactory.initialization("Швеция", (int) (1e5));
        Country USSR = Country.CountryFactory.initializationRandom("СССР", (int) (2e5));

        World world = new World(2022, new Country[]{RUSSIA, SWEDEN, USSR});

        publisher.publish(world, books);
    }
}
