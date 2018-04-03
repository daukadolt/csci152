package csci152.impl;

public class DoublyLinkedNode<T> {

    private T value;

    private DoublyLinkedNode<T> previous;
    private DoublyLinkedNode<T> next;

    public DoublyLinkedNode(T value) {
        this.next = null;
        this.previous = null;
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyLinkedNode<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    public DoublyLinkedNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
