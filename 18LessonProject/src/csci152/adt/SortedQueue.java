package csci152.adt;

public interface SortedQueue<T extends Comparable> {

    public void insert(T value);

    public T dequeue() throws Exception;

    public int getSize();

    public void clear();

    @Override
    public String toString();

}
