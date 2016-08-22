package Passed;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty()) {
            minstack.push(x);
            return;
        }
        int min = getMin();
        if (x < min) {
            minstack.push(x);
        } else {
            minstack.push(min);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) return 0;
        return stack.peek();
    }
    
    public int getMin() {
        if (minstack.isEmpty()) return 0;
        return minstack.peek();
    }
}
