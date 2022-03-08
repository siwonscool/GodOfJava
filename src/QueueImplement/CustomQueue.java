package QueueImplement;

public interface CustomQueue<T> {
    T enqueue(T obj);
    T dequeue();
    T peek();
    int size();
    boolean isEmpty();
    boolean isInQueueRange(int index);
    void removeAt(int index);
}
