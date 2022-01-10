package TheBestLab4;

public class CountryIsAnarchyException extends RuntimeException {
    Country country;

    public CountryIsAnarchyException() {
        super();
    }

    public CountryIsAnarchyException(Country country) {
        this.country = country;
    }

    public CountryIsAnarchyException(String message) {
        super(message);
    }

    public CountryIsAnarchyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryIsAnarchyException(Throwable cause) {
        super(cause);
    }

    protected CountryIsAnarchyException(String message, Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return "В стране " + country.getName() + " анархия. " + country.getName() + " занята более важными делами!";
    }
}
