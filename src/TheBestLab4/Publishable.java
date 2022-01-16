package TheBestLab4;

/**
 * Interface, which describes all Publisher public behavior
 */
@FunctionalInterface
public interface Publishable {

    /**
     * Main method, which creates and prints rating of readables
     */
    void publish(World world, Readable[] readables, Publishable.PublishOption option);

    /**
     * Inner enum consists of two main publish options
     */
    enum PublishOption {
        IN_EACH_COUNTRY,
        ALL_AROUND_THE_WORLD
    }
}
