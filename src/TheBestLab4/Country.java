package TheBestLab4;

import java.util.Arrays;
import java.util.Objects;

public class Country {

    private String name;
    private int population;
    private Person[] people;
    private boolean anarchyFlag = false;
    public static int MAX_POPULATION = (int) (1e6 + 1);

    private Country(String name, int population){
        this.name = name;
        this.population = population;
        people = new Person[population];
    }

    static class CountryFactory{

        public static Country initializationRandom(String name, int population) {
            if (population > MAX_POPULATION) {
                throw new CountryInitializationException(name, population);
            }
            Country thisCountry = new Country(name, population);
            thisCountry.people = new Person[population];
            try {
                immigration(thisCountry);
            } catch (TooManyPeopleException e){
                thisCountry.anarchyFlag = true;
                System.out.println(e.getMessage());
            }
            return thisCountry;
        }

        private static void immigration(Country thisCountry) throws TooManyPeopleException {
            for (int i = 0; i < thisCountry.population + (int) (Math.random() * 1.125); ++i){
                Person person = Person.getRandomPerson();
                try {
                    thisCountry.people[i] = person;
                } catch (ArrayIndexOutOfBoundsException e){
                    throw new TooManyPeopleException(thisCountry, person);
                }
            }
        }

        public static Country initialization(String name, Person[] people) {
            if (people.length > MAX_POPULATION) {
                throw new CountryInitializationException(name, people.length);
            }
            Country thisCountry = new Country(name, people.length);
            thisCountry.people = people;
            return thisCountry;
        }
    }

    public String getName() {return name;}

    public int getPopulation() {
        return population;
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
        return population == country.population && anarchyFlag == country.anarchyFlag && name.equals(country.name) && Arrays.equals(people, country.people);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, population, anarchyFlag);
        result = 31 * result + Arrays.hashCode(people);
        return result;
    }
}
