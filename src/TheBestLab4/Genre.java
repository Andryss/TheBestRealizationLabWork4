package TheBestLab4;

public enum Genre {
    ADVENTURE("Приключенческая книга"),
    VISUAL_NOVEL("Визуальная новелла"),
    DETECTIVE("Детектив"),
    DRAMA("Драма"),
    FANTASY("Фэнтези"),
    SCIENCE_FICTION("Научная фантастика"),
    HISTORICAL("Историческая книга"),
    PSYCHOLOGICAL("Психологическая книга"),
    PULPFICTION("Бульварное чтиво");

    private String name;

    Genre(String name){
        this.name = name;
    }

    public String getName() {return name;}

    public static Genre getRandomGenre(){
        Genre[] genres = Genre.values();
        return genres[(int) (Math.random() * genres.length)];
    }
}
