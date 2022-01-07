package TheBestLab4;

import java.util.Objects;

public enum Country {
    USSR("СССР", 100),
    FRANCE("ФРАНЦИЯ", 100),
    GERMANY("ГЕРМАНИЯ", 100),
    NORWAY("НОРВЕГИЯ", 100);

    private String name;
    private int population;
    private Person[] people;
    private boolean anarchyFlag = false;

    Country(String name, int population){
        this.name = name;
        this.population = population;
        people = new Person[population];
        try {
            immigration();
        } catch (TooManyPeopleException e){
            anarchyFlag = true;
            System.out.println(e.getMessage());
        }
    }

    private void immigration() throws TooManyPeopleException {
        for (int i = 0; i < population + (int) (Math.random() * 1.125); ++i){
            Person person = Person.getRandomPerson();
            try {
                people[i] = person;
            } catch (ArrayIndexOutOfBoundsException e){
                throw new TooManyPeopleException(this, person);
            }
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
        return people;
    }
}
