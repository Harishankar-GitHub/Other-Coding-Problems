import java.util.Stack;

public class QueueUsingStack {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int num) {
        stack1.push(num);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        moveAllElementsFromStack1ToStack2();
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        moveAllElementsFromStack1ToStack2();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    private void moveAllElementsFromStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
