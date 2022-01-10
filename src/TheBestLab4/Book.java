package TheBestLab4;

public class Book implements Readable{
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
        return "\"" + getTitle() + "\" в жанре \"" + getGenre().getName() + "\" автора " + getAuthor() + " (издание " + getEdition() + ")" + getAbout();
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
