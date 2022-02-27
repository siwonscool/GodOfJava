package StackImplement;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericDoubleStack<T> implements CustomStack<T> {
    private T[] data;
    private int dataCount;

    public GenericDoubleStack() {
        this(10);
    }

    public GenericDoubleStack(int initDataCapacity) {
        data = (T[]) new Object[initDataCapacity];
    }

    @Override
    public T push(T obj) {
        if (isFull()) {
            growCapacity();
        }
        data[dataCount++] = obj;
        return obj;
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    private void growCapacity() {
        int afterCapacity = data.length * 2;

        if (afterCapacity > MAX_ARRAY_SIZE) {
            afterCapacity = hugeCapacity(afterCapacity);
        }

        data = Arrays.copyOf(data, afterCapacity);
    }

    private int hugeCapacity(int afterCapacity) {
        if (afterCapacity < 0) {
            throw new OutOfIntegerMAXVAULUE("최대 크기를 초과하였습니다.");
        }
        return MAX_ARRAY_SIZE;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T deleteData = peek();
        removeAt(dataCount - 1);

        if (isSmall()) {
            decreaseCapacity();
        }
        return deleteData;
    }

    private void decreaseCapacity() {
        int afterCapacity = data.length / 2;
        data = Arrays.copyOf(data, afterCapacity);
    }

    @Override
    public void removeAt(int index) {
        if (!isInArray(index)) {
            throw new IndexOutOfBoundsException();
        }

        T[] newData = (T[]) new Object[data.length];
        int remainDataCount = data.length - (index + 1);

        System.arraycopy(data, 0, newData, 0, index);
        System.arraycopy(data, index + 1, newData, index, remainDataCount);

        data = newData;
        dataCount--;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[dataCount - 1];
    }

    @Override
    public int size() {
        return dataCount;
    }

    @Override
    public boolean isEmpty() {
        return (dataCount == 0);
    }

    @Override
    public boolean isFull() {
        return (dataCount == data.length);
    }

    @Override
    public boolean isSmall() {
        return (dataCount < data.length / 2);
    }

    private boolean isInArray(int index) {
        return (index < dataCount && index >= 0);
    }
}