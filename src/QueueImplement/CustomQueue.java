package QueueImplement;

public interface CustomQueue<T> {
    T enqueue(T obj);
    T dequeue();
    T peek();
    int size();
    void removeAt(int index);
    void removeFirst();
    boolean isEmpty();
    boolean isInQueueRange(int index);
}
