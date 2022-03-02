package StackImplement;

public interface CustomStack<T> {
    T push(T obj);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
    boolean isFull();
    boolean isSmall();
    boolean isInArray(int index);
    void removeAt(int index);
}
