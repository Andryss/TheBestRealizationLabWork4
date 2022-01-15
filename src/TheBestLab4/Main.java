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


        Person[] people = new Person[(int) 5e5];
        for (int i = 0; i < people.length; i++) {
            if (i < 163_000) {
                people[i] = new Person("Любитель психологии",new Genre[]{Genre.PSYCHOLOGICAL});
            } else if (i < 163_000 + 92_000) {
                people[i] = new Person("Любитель детективов",new Genre[]{Genre.DETECTIVE});
            } else if (i < 163_000 + 92_000 + 71_000 + 1) {
                people[i] = new Person("Любитель романов (как жанра)",new Genre[]{Genre.NOVEL});
            } else {
                people[i] = new Person("Нелюбитель",new Genre[]{});
            }
        }
        Country RUSSIA = Country.CountryFactory.initialization("Россия", people);


        Country SWEDEN = Country.CountryFactory.initializationRandom("Швеция", (int) (5e5));
        Country USSR = Country.CountryFactory.initializationRandom("СССР", (int) (8e5));


        World world = World.newInstance(2022, new Country[]{RUSSIA, SWEDEN, USSR});


        publisher.publish(world, books, Publisher.PublishOption.ALL_AROUND_THE_WORLD);
    }
}
