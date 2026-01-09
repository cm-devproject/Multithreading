import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); // wait if buffer is full
        }

        buffer.add(value);
        System.out.println("Produced: " + value);

        notify(); // notify consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // wait if buffer is empty
        }

        int value = buffer.remove();
        System.out.println("Consumed: " + value);

        notify(); // notify producer
        return value;
    }
}
