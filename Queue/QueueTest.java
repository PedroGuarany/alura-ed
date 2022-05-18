package Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue("Joao");
        queue.enqueue("Pedro");

        System.out.println(queue);
        String removed = queue.dequeue();
        System.out.println(queue);
        System.out.println(removed);
    }
}
