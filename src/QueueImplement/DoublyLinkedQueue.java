package QueueImplement;

public class DoublyLinkedQueue<T> implements CustomQueue<T>{

    private static class Node<T>{
        T data;
        Node<T> prevNode;
        Node<T> nextNode;

        public Node(T data, Node<T> prevNode, Node<T> nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int queueSize;

    public DoublyLinkedQueue() {
        this.head = null;
        this.tail = null;
        this.queueSize = 0;
    }

    @Override
    public T enqueue(T obj) {
        if(isEmpty()){
            addFirst(obj);
            return obj;
        }

        Node<T> lastNode = search(queueSize - 1);
        Node<T> newNode = new Node<>(obj,lastNode,null);

        lastNode.nextNode = newNode;
        tail = newNode;

        queueSize ++;

        return obj;
    }

    public void addFirst(T obj) {
        if (head == null){
            Node<T> newHead = new Node<>(obj,null,null);

            head = newHead;
            tail = newHead;
            queueSize++;
            return;
        }

        Node<T> prevHead = head;
        Node<T> newHead = new Node<>(obj,null,prevHead);

        head = newHead;
        prevHead.prevNode = newHead;
        tail = prevHead;

        queueSize++;
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

        if (!isInQueueRange(index)){
            throw new OutOfQueueException("저장된 큐의 범위를 초과하였습니다.");
        }

        Node<T> currentNode = search(index);
        Node<T> prevNode = currentNode.prevNode;
        Node<T> nextNode = currentNode.nextNode;

        prevNode.nextNode = nextNode;
        nextNode.prevNode = prevNode;

        queueSize --;
    }

    @Override
    public T peek() {
        return head.data;
    }

    private Node<T> search(int index){
        if (isInHalf(index)){
            return searchToFirst(index);
        }else {
            return searchToLast(index);
        }
    }

    private boolean isInHalf(int index) {
        return index / queueSize < 0.5 ;
    }

    private Node<T> searchToFirst(int index) {
        Node<T> searchNode = head;

        for (int i = 0; i < index; i++) {
            searchNode = searchNode.nextNode;
        }

        return searchNode;
    }

    private Node<T> searchToLast(int index) {
        Node<T> searchNode = tail;

        for (int i = queueSize - 1; i > index; i--) {
            searchNode = searchNode.prevNode;
        }

        return searchNode;
    }


    @Override
    public int size() {
        return queueSize;
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
