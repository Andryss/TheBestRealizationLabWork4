package TheBestLab4;

public class TooManyPeopleException extends Exception {
    private Country country;
    private Person person;

    public TooManyPeopleException() {
        super();
    }

    public TooManyPeopleException(Country country, Person person){
        this.country = country;
        this.person = person;
    }

    public TooManyPeopleException(String message) {
        super(message);
    }

    public TooManyPeopleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyPeopleException(Throwable cause) {
        super(cause);
    }

    protected TooManyPeopleException(String message, Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getMessage(){
        return "В стране " + country.getName() + " началась анархия, из-за перенаселения, вызванного рождением " + person.getName() + ". Теперь " + country.getName() + " занята более важными делами.";
    }
}