package StackImplement;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericTenStack<T> implements CustomStack<T>
{
    private T[] data;
    private int capacityIncrement;
    private int dataCount;

    public GenericTenStack(){
        this(10,0);
    }

    public GenericTenStack(int initDataCapacity){
        this(initDataCapacity,0);
    }

    public GenericTenStack(int initDataCapacity, int capacityIncrement){
        this.capacityIncrement = capacityIncrement;
        data = (T[]) new Object[initDataCapacity];
    }

    @Override
    public T push(T obj){
        if(isFull()){
            growCapacity();
        }
        data[dataCount++] = obj;
        return obj;
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    private void growCapacity(){
        int afterCapacity = data.length + capacityIncrement + 10;

        if(afterCapacity > MAX_ARRAY_SIZE){
            afterCapacity = hugeCapacity(afterCapacity);
        }

        data = Arrays.copyOf(data,afterCapacity);
    }

    private int hugeCapacity(int minDataCapacity){
        //데이터가 담긴 수가 int 형의 범위를 넘어가게 되면 음수가 되어버리는걸 확인
        if(minDataCapacity < 0){
            throw new OutOfIntegerMAXVAULUE("최대 크기를 초과하였습니다.");
        }
        return MAX_ARRAY_SIZE;
    }

    @Override
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        T deleteData = peek();
        removeAt(dataCount - 1);

        if (isSmall()){
            decreaseCapacity();
        }
        return deleteData;
    }

    @Override
    public void removeAt(int index){
        if(!isInArray(index)){
            throw new IndexOutOfBoundsException();
        }

        for (int i = index ; i < dataCount - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--dataCount] = null;
    }

    private void decreaseCapacity() {
        int afterCapacity = data.length - (10 + capacityIncrement);
        data = Arrays.copyOf(data,afterCapacity);
    }

    @Override
    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return data[dataCount - 1];
    }

    @Override
    public int size(){
        return dataCount;
    }

    @Override
    public boolean isEmpty(){
        return (dataCount == 0);
    }

    @Override
    public boolean isFull(){
        return (dataCount == data.length);
    }

    @Override
    public boolean isSmall(){
        return (data.length - dataCount > 10 + capacityIncrement);
    }

    @Override
    public boolean isInArray(int index){
        return (index < dataCount && index >= 0);
    }
}
