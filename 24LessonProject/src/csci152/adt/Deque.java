package csci152.adt;

public interface Deque<T> {

    public void pushToFront(T value);

    public void pushToBack(T value);

    public T popFromFront() throws Exception;

    public T popFromBack() throws Exception;

    public int getSize();

    public void clear();

    @Override
    public String toString();

}
