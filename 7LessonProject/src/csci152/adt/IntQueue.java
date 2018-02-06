package csci152.adt;

public interface IntQueue {

    public void enqueue(int value);

    public int dequeue() throws Exception;

    public int getSize();

    public void clear();

    @Override
    public String toString();


}
