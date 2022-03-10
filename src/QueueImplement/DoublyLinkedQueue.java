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

    private void addFirst(T obj) {
        if (head == null){
            head = new Node<>(obj,null,null);
            tail = head;
            queueSize++;
            return;
        }

        Node<T> prevHead = head;
        head = new Node<>(obj,null,prevHead);
        prevHead.prevNode = head;
        queueSize++;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public void removeAt(int index) {

    }

    @Override
    public T peek() {
        return head.data;
    }

    private Node<T> search(int index){
        return head;
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
