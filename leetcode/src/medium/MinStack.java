package medium;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty() || stack2.peek()>=val){
            stack2.push(val);
        }
    }

    public void pop() {
        int val = stack1.pop();
        if (val == stack2.peek()){
            stack2.pop();
        }
        return;
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
