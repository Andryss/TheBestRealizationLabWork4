package TheBestLab4;

import java.util.Objects;

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

    public String toString(){
        return read();
    }

    public int hashCode(){
        return Objects.hash(author, title, genre, about);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Book b = (Book) (o);
        return Objects.equals(getAuthor(), b.getAuthor()) && Objects.equals(getAbout(), b.getAbout()) && Objects.equals(getGenre(), b.getGenre()) && Objects.equals(getTitle(), ((Book) o).getTitle());
    }

}
