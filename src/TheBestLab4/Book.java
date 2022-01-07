package TheBestLab4;

public enum Book implements Readable{
    HARRYPOTTER("Джоан Роулинг", "Гарри Поттер", Genre.ADVENTURE, 3, ", повествующая о мальчике, который выжил"),
    THESTAINLESSSTEELRAT("Гарри Гаррисон", "Стальная крыса",Genre.SCIENCE_FICTION, 1, " - это серия научно-фантастических юмористических произведений Гарри Гаррисона (в основном, романов) о похождениях в отдалённом будущем ловкого галактического мошенника Джеймса Боливара Ди Гриза");


    private String author;
    private String title;
    private Genre genre;
    private int edition;
    private String about;

    Book(String author, String title, Genre genre, int edition, String about){
        this.author = author;
        this.about = about;
        this.edition = edition;
        this.genre = genre;
        this.title = title;
    }

    public String read(){
        return getTitle() + " автора " + getAuthor() + " издание " + getEdition() + " в жанре " + getGenre().getName() + getAbout();
    }

    public Genre getGenre() {
        return genre;
    }

    public int getEdition() {
        return edition;
    }

    public String getAbout() {
        return about;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

}
