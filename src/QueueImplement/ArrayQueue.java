package QueueImplement;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayQueue<T> implements CustomQueue<T>{

    private static final int front = 0;
    private int tail;
    private int dataSize;
    private T[] data;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int dataSize) {
        this.dataSize = dataSize;
        this.tail = 0;
        data = (T[]) new Object[dataSize];
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
            throw new EmptyQueueException("큐가 비어있습니다.");
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
        if (isInQueueRange(index)){
            throw new OutOfQueueException("저장된 큐의 범위를 초과하였습니다.");
        }

        T[] newData1 = Arrays.copyOfRange(data, front, index);
        T[] newData2 = Arrays.copyOfRange(data,index + 1, tail);

        data = (T[]) Stream.concat(Arrays.stream(newData1),Arrays.stream(newData2)).toArray(Object[]::new);

        tail--;
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
        return search(front);
    }

    public T search(int index) {
        if (isInQueueRange(index)){
            throw new OutOfQueueException("저장된 큐의 범위를 초과하였습니다.");
        }
        return data[index];
    }

    @Override
    public int size() {
        return tail - front;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    public boolean isFull() {
        return tail == dataSize;
    }

    @Override
    public boolean isInQueueRange(int index) {
        return (index >= front) && (index < tail);
    }
}
