package QueueImplement;

public class OutOfQueueException extends RuntimeException {
    public OutOfQueueException() {
        super();
    }

    public OutOfQueueException(String message) {
        super(message);
    }
}
