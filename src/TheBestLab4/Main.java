package TheBestLab4;

//import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        /*
        STEP1: CREATE PUBLISHER ----------------------------------------------------------------------------------------
         */
        PurchasingPublisher publisher = new PurchasingPublisher("Компания \"Эксмо\"");

//        ChoosingBestPublisher publisher = new ChoosingBestPublisher("Компания \"Эксмо\"");
//        ChoosingWorstPublisher publisher = new ChoosingWorstPublisher("Компания \"Эксмо\"");


//        class OpinionPublisher extends Publisher {
//
//            public OpinionPublisher(String name) {
//                super(name);
//            }
//
//            @Override
//            protected Readable[] invokePersonMethod(Person person, Readable[] readables) {
//                Readable theBest = person.chooseTheBest(readables);
//                Readable theWorst = person.chooseTheWorst(readables);
//                if (theBest != null && theWorst != null) {
//                    return new Readable[]{theBest, theWorst};
//                } else if (theBest == null && theWorst != null) {
//                    return new Readable[]{theWorst};
//                } else if (theBest != null) {
//                    return new Readable[]{theBest};
//                } else {
//                    return new Readable[]{};
//                }
//            }
//
//            @Override
//            protected void printResult(Readable[] readables, Map<Readable, Integer> rating) {
//                System.out.println("Абсолютным победителем, вызвавшим наибольший общественный резонанс стала книга: " + readables[0]);
//                System.out.println("Эта книга небезразлична " + rating.get(readables[0]) / 1000 + " тыс. читателям.");
//            }
//        }
//        OpinionPublisher publisher = new OpinionPublisher("Компания \"Эксмо\"");


        /*
        STEP2: CREATE READABLES (BOOKS) --------------------------------------------------------------------------------
         */
        Book harryPotter = new Book("Джоан Роулинг","Гарри Поттер",Genre.ADVENTURE,"повествует о мальчике, который выжил");
        Book theStainlessSteelRat = new Book("Гарри Гаррисон","Стальная крыса",Genre.SCIENCE_FICTION,"это серия научно-фантастических юмористических произведений Гарри Гаррисона (в основном, романов) о похождениях в отдалённом будущем ловкого галактического мошенника Джеймса Боливара Ди Гриза");
        Book firstPlace = new Book("Михаил Лабковский","Хочу и буду",Genre.PSYCHOLOGICAL);
        Book secondPlace = new Book("Майк Омер","Внутри убийцы",Genre.DETECTIVE,"криминальный психолог-женщина расследует череду жестоких преступлений");
        Book thirdPlace = new Book("Виктор Пелевин","Transhumanism inc.",Genre.NOVEL);
        Readable[] books = {harryPotter, theStainlessSteelRat, firstPlace, secondPlace, thirdPlace};
//        Readable infoGypsyBook = new Readable(){
//
//            public String read(){
//                String allGenres = Arrays.toString(Genre.values());
//                return " название и автор книги стали легендарными всего через несколько дней после публикации.\n" +
//                        "Теперь сложно представить хотя бы одного человека, кто не только не слышал, но и не зачитывался этой книгой несколько десятков раз за вечер.\n" +
//                        "Хорошая книга. " + allGenres.substring(1,allGenres.length()-1) + ".\n" +
//                        "(Доступна для покупки во всех магазинах мира всего за 999.99$)";
//            }
//
//
//        };
//        Readable bookAboutNothing = () -> "Эта книга ни о чём для настоящих \"Нелюбителей\".\n Не тратьте на неё время...";
//        Readable[] books = {harryPotter, theStainlessSteelRat, firstPlace, secondPlace, thirdPlace, infoGypsyBook, bookAboutNothing};


        /*
        STEP3: CREATE COUNTRIES ----------------------------------------------------------------------------------------
         */
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
//        Country.AnarchyLeader heWhoMustNotBeNamed = RUSSIA.new AnarchyLeader("Алексей");
//        heWhoMustNotBeNamed.makeAnarchyInCountry();


//        Country SWEDEN = Country.CountryFactory.initializationRandom("Швеция", (int) (5e5));
//        Country USSR = Country.CountryFactory.initializationRandom("СССР", (int) (8e5));


        /*
        STEP4: CREATE WORLD CONSIST OF CREATED COUNTRIES
         */
        World world = World.newInstance(2021, new Country[]{RUSSIA});
//        World world = World.newInstance(2022, new Country[]{RUSSIA, SWEDEN, USSR});


        /*
        STEP5: LET THE GAME BEGIN!!! -----------------------------------------------------------------------------------
         */
        publisher.publish(world, books, Publisher.PublishOption.IN_EACH_COUNTRY);
    }
}
