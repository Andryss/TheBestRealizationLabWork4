package TheBestLab4;

public enum Country {
    USSR("СССР", 1_000_000),
    FRANCE("ФРАНЦИЯ", 1_000_000),
    GERMANY("ГЕРМАНИЯ", 1_000_000),
    NORWAY("НОРВЕГИЯ", 1_000_000);

    private String name;
    private int population;
    private Person[] people;
    private boolean anarchyFlag = false;

    Country(String name, int population){
        this.name = name;
        this.population = population;
    }

    public void initializationRandom() {
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

    public void initialization(Person[] people) {
        if (people.length != population) {
            throw new CountryInitializationException(this, people);
        }
        this.people = people;
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
}
