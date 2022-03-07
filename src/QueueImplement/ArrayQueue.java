package QueueImplement;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayQueue<T> implements CustomQueue<T>{

    private static final int front = 0;
    private int tail;
    private int queueSize;
    private T[] data;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int queueSize) {
        this.queueSize = queueSize;
        this.tail = 0;
        data = (T[]) new Object[queueSize];
    }

    @Override
    public T enqueue(T obj) {
        if(isFull()){
            growQueue();
        }
        data[tail++] = obj;
        return obj;
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    private void growQueue() {
        int afterCapacity = data.length * 2;

        if (afterCapacity > MAX_ARRAY_SIZE){
            afterCapacity = hugeCapacity(afterCapacity);
        }

        data= Arrays.copyOf(data,afterCapacity);
    }

    private int hugeCapacity(int afterCapacity) {

        if (afterCapacity < 0){
            throw new IndexOutOfBoundsException();
        }

        afterCapacity = MAX_ARRAY_SIZE;
        return afterCapacity;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new EmptyQueueException("현재 큐가 비어있습니다.");
        }

        T deleteData = peek();
        removeAt(front);

        if(isSmall()){
            decreaseQueue();
        }

        return deleteData;
    }

    @Override
    public void removeAt(int index) {
        if (isInArray(index)){
            throw new OutOfQueueException("현재 저장된 큐의 범위를 초과하였습니다.");
        }

        T[] newData1 = Arrays.copyOfRange(data, front, index);
        T[] newData2 = Arrays.copyOfRange(data,index + 1, tail);

        data = (T[]) Stream.concat(Arrays.stream(newData1),Arrays.stream(newData2)).toArray(Object[]::new);

        tail--;
    }

    private boolean isInArray(int index) {
        return (index >= front) && (index < tail);
    }

    private boolean isSmall() {
        return size() < data.length / 2;
    }

    private void decreaseQueue() {
        int afterCapacity = data.length / 2;
        data = Arrays.copyOf(data, afterCapacity);
    }

    @Override
    public T peek() {
        return data[front];
    }

    @Override
    public int size() {
        return tail - front;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public boolean isFull() {
        return tail == queueSize;
    }
}
