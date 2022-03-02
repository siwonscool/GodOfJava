package StackImplement;


import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.IntStream;

public class IntegerTenStack implements CustomStack<Integer> {
    private int[] data;
    private int dataCount;

    public IntegerTenStack() {
        this(10);
    }

    public IntegerTenStack(int initDataCapacity) {
        data = new int[initDataCapacity];
    }

    @Override
    public Integer push(Integer obj) {
        if (isFull()){
            growCapacity();
        }
        data[dataCount++] = obj;
        return obj;
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    private void growCapacity() {
        int afterCapacity = data.length + 10;

        if(afterCapacity > MAX_ARRAY_SIZE){
            afterCapacity = hugeCapacity(afterCapacity);
        }

        data = Arrays.copyOf(data,afterCapacity);
    }

    private int hugeCapacity(int afterCapacity) {
        if(afterCapacity < 0){
            throw new OutOfIntegerMAXVAULUE("최대 크기를 초과하였습니다.");
        }
        return MAX_ARRAY_SIZE;
    }

    @Override
    public Integer pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }

        Integer deleteData = peek();
        removeAt(dataCount - 1);

        if (isSmall()){
            decreaseCapacity();
        }
        return deleteData;
    }

    @Override
    public void removeAt(int index) {
        if(!isInArray(index)){
            throw new IndexOutOfBoundsException();
        }

        int[] newData1 = Arrays.copyOfRange(data,0,index);
        int[] newData2 = Arrays.copyOfRange(data,index + 1,dataCount);
        data = IntStream.concat(IntStream.of(newData1),IntStream.of(newData2)).toArray();

        dataCount --;
    }

    private void decreaseCapacity() {
        int afterCapacity = data.length - 10;
        data = Arrays.copyOf(data,afterCapacity);
    }

    @Override
    public Integer peek() {
        if (isEmpty()){
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
        return (dataCount==0);
    }

    @Override
    public boolean isFull() {
        return (dataCount == data.length);
    }

    @Override
    public boolean isSmall() {
        return (data.length - dataCount > 10);
    }

    @Override
    public boolean isInArray(int index){
        return (index < dataCount && index >= 0);
    }
}
