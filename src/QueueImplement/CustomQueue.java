package QueueImplement;

public interface CustomQueue<T> {
    T enqueue(T obj);
    T dequeue();
    T peek();
    int size();
    boolean isEmpty();
    boolean isFull();
    void removeAt(int index);
}
