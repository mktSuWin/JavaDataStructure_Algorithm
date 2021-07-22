package stack;

public class UA_QueueDriver {
    public static void main(String[] args) {
        UA_Queue queue = new UA_Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(50);
        queue.enqueue(60);
        queue.displayQueue();
        // 30 40 50 60
        System.out.println(queue.peekFront());
    }
}
