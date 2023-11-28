package src;

public interface Storage<T extends Storable> {
    void storeItem(T item);

    int getMaxStorage();

    void setMaxStorage(int num);
}
