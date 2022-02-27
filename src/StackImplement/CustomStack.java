package StackImplement;

public interface CustomStack<T> {
    public T push(T obj);
    public T pop();
    public T peek();
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public boolean isSmall();
    public void removeAt(int index);
}
