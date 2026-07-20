import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    // Single queue to simulate a stack
    private Queue<Integer> queue;

    // Initializes the stack object
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Pushes element x to the top of the stack
    public void push(int x) {
        // 1. Add the new element to the back of the queue
        queue.add(x);
        
        // 2. Rotate the queue so the new element moves to the front
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    // Removes the element on the top of the stack and returns it
    public int pop() {
        return queue.remove();
    }  
    // Returns the element on the top of the stack
    public int top() {
        return queue.peek();
    }
    
    // Returns true if the stack is empty, false otherwise
    public boolean empty() {
        return queue.isEmpty();
    }
}
