package TheBestLab4;

public class Book implements Readable{
    private String author;
    private String title;
    private Genre genre;
    private String about;

    Book(String author, String title, Genre genre, String about){
        this.author = author;
        this.about = about;
        this.genre = genre;
        this.title = title;
    }

    Book(String author, String title, Genre genre){
        this(author,title,genre,"*неизвестное содержимое*");
    }

    public String read(){
        return "\"" + getTitle() + "\" в жанре \"" + getGenre().getName() + "\" автора " + getAuthor() + " (" + getAbout() + ")";
    }

    public Genre getGenre() {
        return genre;
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
