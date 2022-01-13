package TheBestLab4;

public class CountryInitializationException extends RuntimeException {
    private Country country;
    private Person[] people;

    public CountryInitializationException() {
        super();
    }

    public CountryInitializationException(Country country, Person[] people) {
        this.country = country;
        this.people = people;
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
        return "Страна " + country.getName() + " c населением " + country.getPopulation() + " не может поместить " + people.length + " людей.";
    }
}
