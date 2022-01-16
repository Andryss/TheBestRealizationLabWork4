package TheBestLab4;

/**
 * Country can't set People[] if user gives wrong length of People[]
 */
public class CountryInitializationException extends RuntimeException {
    String country;
    private int population;

    public CountryInitializationException() {
        super();
    }

    public CountryInitializationException(String name, int population) {
        this.country = name;
        this.population = population;
    }

    public CountryInitializationException(String message) {
        super(message);
    }

    public CountryInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryInitializationException(Throwable cause) {
        super(cause);
    }

    protected CountryInitializationException(String message, Throwable cause,
                                        boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return "Страна " + country + " c населением " + population + " не может существовать, так как максимальное возможное население страны " + Country.MAX_POPULATION + " людей.";
    }
}
