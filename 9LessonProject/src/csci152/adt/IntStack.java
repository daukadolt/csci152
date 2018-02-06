package csci152.adt;

public interface IntStack {

    public void push(int value);

    public int pop() throws Exception;

    public int getSize();

    public void clear();

    @Override
    public String toString();

}
