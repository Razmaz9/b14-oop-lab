package src;

public interface RAStorage<T extends Car> extends Storage<T> {
    // "Random Access Storage", any car can be removed from the storage
    void removeItem(T item);
}
