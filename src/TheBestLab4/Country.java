package TheBestLab4;

import java.util.Arrays;
import java.util.Objects;

/**
 * <p>Country class represent simple Country with population</p>
 * <p>County is a person-container</p>
 */
public class Country {

    private final String name;
    private Person[] people;
    private boolean anarchyFlag = false;
    public static int MAX_POPULATION = (int) (1e6 + 1);

    private Country(String name, int population){
        this.name = name;
        people = new Person[population];
    }

    /**
     * Inner static factory-class CountryFactory, which creates Country classes
     */
    static class CountryFactory{

        /**
         * Method, which creates country randomly (may couse some problems)
         * @param name new Country name
         * @param population new Country population (or Peeson[].length)
         * @return created Country (maybe anarchy)
         */
        public static Country initializationRandom(String name, int population) {
            if (population > MAX_POPULATION) {
                throw new CountryInitializationException(name, population);
            }
            Country thisCountry = new Country(name, population);
            try {
                immigration(thisCountry);
            } catch (TooManyPeopleException e){
                thisCountry.anarchyFlag = true;
                System.out.println(e.getMessage());
            }
            return thisCountry;
        }

        /**
         * Private method, which fill County with persons
         * @param thisCountry Country we need to fill
         * @throws TooManyPeopleException it's random, so there is a chance to overpopulation
         */
        private static void immigration(Country thisCountry) throws TooManyPeopleException {
            for (int i = 0; i < thisCountry.people.length + (int) (Math.random() * 1.125); ++i){
                Person person = Person.getRandomPerson();
                try {
                    thisCountry.people[i] = person;
                } catch (ArrayIndexOutOfBoundsException e){
                    throw new TooManyPeopleException(thisCountry, person);
                }
            }
        }

        /**
         * Method, which creates country without random. It's multi-setter
         * @param name new Country name
         * @param people list of persons we want to set
         * @return created Country (without anarchy)
         */
        public static Country initialization(String name, Person[] people) {
            if (people.length > MAX_POPULATION) {
                throw new CountryInitializationException(name, people.length);
            }
            Country thisCountry = new Country(name, people.length);
            thisCountry.people = people;
            return thisCountry;
        }
    }

    /**
     * Inner non-static class AnarchyLeader represent person, who can make country anarchy
     */
    public class AnarchyLeader{
        String name;

        public AnarchyLeader(String name){
            this.name = name;
        }

        /**
         * Method, which makes country anarchy
         */
        public void makeAnarchyInCountry(){
            Country.this.anarchyFlag = true;
            System.out.println("В стране " + getName() + " вспыхнуло восстание, лидером которого стал " + name + ".");
        }
    }

    public String getName() {return name;}

    public int getPopulation() {
        if (isAnarchy()) {
            throw new CountryIsAnarchyException(this);
        }
        return people.length;
    }

    public boolean isAnarchy() {
        return anarchyFlag;
    }

    public Person[] getPeople() {
        if (isAnarchy()) {
            throw new CountryIsAnarchyException(this);
        }
        return people;
    }

    public String toString(){
        return "Country " + getName() + " with population " + getPopulation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return anarchyFlag == country.anarchyFlag && name.equals(country.name) && Arrays.equals(people, country.people);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, anarchyFlag);
        result = 31 * result + Arrays.hashCode(people);
        return result;
    }
}
