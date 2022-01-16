package TheBestLab4;

/**
 * Enum Genre represents real genres and consists a few main genres
 */
public enum Genre {
    ADVENTURE("Приключенческая книга"),
    VISUAL_NOVEL("Визуальная новелла"),
    DETECTIVE("Детектив"),
    DRAMA("Драма"),
    FANTASY("Фэнтези"),
    SCIENCE_FICTION("Научная фантастика"),
    HISTORICAL("Историческая книга"),
    PSYCHOLOGICAL("Психологическая книга"),
    PULPFICTION("Бульварное чтиво"),
    ANIME("Аниме"),
    NOVEL("Роман");

    private String name;

    Genre(String name){
        this.name = name;
    }

    public String getName() {return name;}

    /**
     * Method with generating random Genre
     * @return random-generated Genre
     */
    public static Genre getRandomGenre(){
        Genre[] genres = Genre.values();
        return genres[(int) (Math.random() * genres.length)];
    }

    /**
     * Method with generating random Genre[]
     * @return random-generated Genre[]
     */
    public static Genre[] getRandomGenres(){
        int curLengthGenres = (int) (Math.random() * 4);
        Genre[] curGenres = new Genre[curLengthGenres];
        int cnt = 0;
        while (cnt != curLengthGenres){
            Genre curGenre = Genre.getRandomGenre();
            if (!Genre.isIn(curGenre, curGenres)){
                curGenres[cnt] = curGenre;
                cnt++;
            }
        }
        return curGenres;
    }

    /**
     * Method, which checks if <code>Genre[]<code/> contains <code>Genre<code/>
     * @param o Genre
     * @param os Genres list
     * @return <code>true if Genre[] contains Genre else false<code/>
     */
    public static boolean isIn(Genre o, Genre[] os){
        boolean fl = false;
        for (Genre o1: os){
            if (o1 == o){
                fl = true;
                break;
            }
        }
        return fl;
    }

    @Override
    public String toString() {
        return getName();
    }
}
