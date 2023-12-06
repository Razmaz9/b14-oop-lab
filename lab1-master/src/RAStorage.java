package src;

public interface RAStorage<T extends Storable> extends Storage<T> {
    // "Random Access Storage", any car can be removed from the storage
    void removeItem(T item);
}
