package src;

public interface LIFOStorage<T extends Storable> extends Storage<T> {
    // "Last In First Out Storage", only the last car can be removed from the storage
    void removeLastItem();
}
