package QueueImplement;

public class SingleLinkedQueue<T> implements CustomQueue<T>{

    private static class Node<T>{
        T data;
        Node<T> nextNode;

        public Node(T data, Node<T> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    private Node<T> head;
    private int queueSize;

    public SingleLinkedQueue() {
        head = null;
        queueSize = 0;
    }

    @Override
    public T enqueue(T obj) {
        if (isEmpty()){
            addFirst(obj);
            return obj;
        }

        Node<T> lastNode = search(queueSize - 1);
        lastNode.nextNode = new Node<>(obj,null);
        System.out.println("enqueue 전 큐 size() : " + size());
        queueSize = queueSize + 1;
        System.out.println("enqueue 후 연산 후 큐 size() : " + size());
        return obj;
    }

    public void addFirst(T obj) {
        if (head == null){
            head = new Node<>(obj,null);
            queueSize++;
            return;
        }

        Node<T> prevHead = head;
        head = new Node<>(obj,prevHead);

        System.out.println("addFirst 전 큐 size() : " + size());
        queueSize = queueSize + 1;
        System.out.println("addFirst 후 큐 size() : " + size());
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new EmptyQueueException("큐가 비어있습니다.");
        }

        T deleteData = peek();
        removeAt(0);

        return deleteData;
    }

    @Override
    public void removeAt(int index) {
        if (isEmpty()){
            throw new EmptyQueueException("큐가 비어있습니다.");
        }

        if (isInQueueRange(index)){
            throw new OutOfQueueException("저장된 큐의 범위를 초과하였습니다.");
        }

        if(index == 0){
            removeFirst();
            return;
        }

        Node<T> prevDeleteData = search(index - 1);
        Node<T> deleteData = search(index);
        Node<T> nextDeleteData = deleteData.nextNode;

        //deleteData 는 GC의 대상이 되는가?
        prevDeleteData.nextNode = nextDeleteData;
        queueSize = queueSize - 1;
    }

    public void removeFirst(){
        if (isEmpty()){
            throw new EmptyQueueException("큐가 비어있습니다.");
        }

        //기존의 head 는 GC의 대상이 되는가?
        head = head.nextNode;
        queueSize = queueSize - 1;
    }

    @Override
    public T peek() {
        return head.data;
    }

    public Node<T> search(int index) {
        if (isEmpty()){
            throw new EmptyQueueException("큐가 비어있습니다.");
        }

        if (isInQueueRange(index)){
            throw new OutOfQueueException("저장된 큐의 범위를 초과하였습니다.");
        }

        Node<T> searchNode = head;

        for (int i = 0; i < index + 1; i++) {
            searchNode = searchNode.nextNode;
        }

        return searchNode;
    }

    @Override
    public int size() {
        return this.queueSize;
    }

    @Override
    public boolean isEmpty() {
        return queueSize == 0;
    }

    @Override
    public boolean isInQueueRange(int index) {
        return (index >= 0 && index < queueSize);
    }

}
