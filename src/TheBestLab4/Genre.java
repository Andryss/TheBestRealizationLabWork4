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
    PULPFICTION("Бульварное чтиво"),
    NOVEL("Роман");

    private String name;

    Genre(String name){
        this.name = name;
    }

    public String getName() {return name;}

    public static Genre getRandomGenre(){
        Genre[] genres = Genre.values();
        return genres[(int) (Math.random() * genres.length)];
    }

    public static Genre[] getRandomGenres(){
        int curLengthGenres = (int) (Math.random() * 3 + 1);
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
