/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x)
            min.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.err.println("Stack is empty!");
        } else {
            int num = stack.pop();
            if (num <= min.peek())
                min.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            System.err.println("Stack is empty!");
            return -1;
        } else {
            return stack.peek();
        }
    }

    public int getMin() {
        if (min.isEmpty()) {
            System.err.println("Stack is empty!");
            return -1;
        } else {
            return min.peek();
        }
    }
}
