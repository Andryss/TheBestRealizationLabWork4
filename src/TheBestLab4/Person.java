package TheBestLab4;

public class Person {
    private static final String[] names = new String[]{"Аркадий", "Андрей", "Иван", "Мария", "Татьяна", "Владислав"};
    private String name;
    private Genre[] favouriteGenres;

    public Person(String name, Genre[] genres){
        this.name = name;
        this.favouriteGenres = genres;
    }

    public static String getRandomName(){
        return names[(int) (names.length * Math.random())];
    }

    public static Person getRandomPerson() {
        return new Person(Person.getRandomName(), Genre.getRandomGenres());
    }

    public Genre[] getFavouriteGenres() {
        return favouriteGenres;
    }

    public String getName() {
        return name;
    }

    public Readable[] whatYouBuy(Readable[] readables){
        Readable[] whatIBuy;
        int cnt = 0;
        for (Readable readable: readables){
            for (Genre genre: favouriteGenres){
                if (readable.read().contains(genre.getName())){
                    cnt++;
                    break;
                }
            }
        }
        whatIBuy = new Readable[cnt];
        cnt = 0;
        for (Readable readable: readables){
            for (Genre genre: favouriteGenres){
                if (readable.read().contains(genre.getName())){
                    whatIBuy[cnt] = readable;
                    cnt++;
                    break;
                }
            }
        }
        return whatIBuy;
    }

    public Readable chooseTheBest(Readable[] readables){
        Readable[] whatIChoose;
        int cnt = 0;
        for (Readable readable: readables){
            for (Genre genre: favouriteGenres){
                if (readable.read().contains(genre.getName())){
                    cnt++;
                    break;
                }
            }
        }
        whatIChoose = new Readable[cnt];
        cnt = 0;
        for (Readable readable: readables){
            for (Genre genre: favouriteGenres){
                if (readable.read().contains(genre.getName())){
                    whatIChoose[cnt] = readable;
                    cnt++;
                    break;
                }
            }
        }
        if (whatIChoose.length > 0) {
            return whatIChoose[(int)(Math.random() * whatIChoose.length)];
        }
        return null;
    }

    public Readable chooseTheWorst(Readable[] readables){
        Readable[] whatIChoose;
        int cnt = 0;
        for (Readable readable: readables){
            for (Genre genre: favouriteGenres){
                if (!readable.read().contains(genre.getName())){
                    cnt++;
                    break;
                }
            }
        }
        whatIChoose = new Readable[cnt];
        cnt = 0;
        for (Readable readable: readables){
            for (Genre genre: favouriteGenres){
                if (!readable.read().contains(genre.getName())){
                    whatIChoose[cnt] = readable;
                    cnt++;
                    break;
                }
            }
        }
        if (whatIChoose.length > 0) {
            return whatIChoose[(int)(Math.random() * whatIChoose.length)];
        }
        return null;
    }

    public String toString(){
        return "Person " + name;
    }
}
