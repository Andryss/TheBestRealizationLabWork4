package TheBestLab4;

import java.util.Objects;

public abstract class Publisher {

    private String name;

    public Publisher(String name){
        this.name = name;
    }

    abstract public void publish(World world, Readable[] readables);

    public String getName() {
        return name;
    }

    public String toString(){
        return getClass().getName() + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
