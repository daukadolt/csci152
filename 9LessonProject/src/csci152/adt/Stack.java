package csci152.adt;

public interface Stack<T> {

    public void push(T value);

    public T pop() throws Exception;

    public int getSize();

    public void clear();

    @Override
    public String toString();

}
