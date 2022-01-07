package TheBestLab4;

public abstract class Publisher {

    private String name;

    public Publisher(String name){
        this.name = name;
    }

    abstract public void publish(World world, Readable[] readables);

    public String getName() {
        return name;
    }
}
