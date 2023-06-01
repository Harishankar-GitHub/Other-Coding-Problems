public class Solution {

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());    // Output: 1
        System.out.println(queue.dequeue());    // Output: 2

        queue.enqueue(4);

        System.out.println(queue.dequeue());    // Output: 3

        System.out.println(queue.peek());   // Output: 3
        System.out.println(queue.size());   // Output: 2
        System.out.println(queue.isEmpty());    // Output: false
    }
}
