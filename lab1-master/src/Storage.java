package src;

public interface Storage<T> {
    void storeItem(T item);

    int getMaxStorage();

    void setMaxStorage(int num);
}
