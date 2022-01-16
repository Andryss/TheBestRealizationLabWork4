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
        Readable infoGypsyBook = new Readable(){

            public String read(){
                return " название и автор которой стали легендарными всего через несколько дней после публикации.\n" +
                        " Теперь сложно представить хотя бы одного человека, кто не просто не слышал, но не зачитывался этой книгой несколько десятков раз за вечер.\n" +
                        "Хорошая книга. Детектив. Приключенческая книга. Визуальная новелла. Драма. Аниме. Бульварное чтиво. Психологическая книга. Историческая книга. Фэнтези. Научная фантастика. Роман.\n" +
                        "(Доступна для покупки во всех магазинах мира всего за 999.99$)";
            }


        };
        Readable bookAboutNothing = () -> "Эта книга ни о чём для настоящих \"Нелюбителей\".\n Не тратьте на неё время...";
        Readable[] books = {harryPotter, theStainlessSteelRat, firstPlace, secondPlace, thirdPlace};
//        Readable[] books = {harryPotter, theStainlessSteelRat, firstPlace, secondPlace, thirdPlace, infoGypsyBook, bookAboutNothing};


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
//        Country.CountryLeader heWhoMustNotBeNamed = RUSSIA.new CountryLeader("Алексей");
//        heWhoMustNotBeNamed.makeAnarchyInCountry();


        Country SWEDEN = Country.CountryFactory.initializationRandom("Швеция", (int) (5e5));
        Country USSR = Country.CountryFactory.initializationRandom("СССР", (int) (8e5));


        World world = World.newInstance(2022, new Country[]{RUSSIA, SWEDEN, USSR});


        publisher.publish(world, books, Publisher.PublishOption.ALL_AROUND_THE_WORLD);
    }
}
