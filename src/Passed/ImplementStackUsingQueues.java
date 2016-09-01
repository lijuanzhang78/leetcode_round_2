package Passed;

public class ImplementStackUsingQueues {
	Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    
    
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.isEmpty()) return;
        
        while(queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Get the top element.
    public int top() {
        if (queue1.isEmpty()) return 0;
        
        while(queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.poll();
        queue2.offer(res);
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }

}
