package src;

public interface LIFOStorage<T extends Car> extends Storage<T> {
    // "Last In First Out Storage", only the last car can be removed from the storage
    void removeLastItem();
}
