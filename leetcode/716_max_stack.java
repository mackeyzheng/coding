class MaxStack {

    /** initialize your data structure here. */

    private final Deque<Integer> stack;
    private final Deque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || maxStack.peek() <= x) {
            maxStack.push(x);
        }
    }

    public int pop() {
        if (stack.isEmpty()) throw new RuntimeException("empty");
        int ret = stack.pop();
        if (ret == maxStack.peek()) {
            maxStack.pop();
        }
        return ret;
    }

    public int top() {
        if (stack.isEmpty()) throw new RuntimeException("empty");
        return stack.peek();
    }

    public int peekMax() {
        if (maxStack.isEmpty()) throw new RuntimeException("empty");
        return maxStack.peek();
    }

    public int popMax() {
        if (maxStack.isEmpty()) throw new RuntimeException("empty");
        int ret = maxStack.pop();
        Deque<Integer> tmp = new ArrayDeque<>();
        while (!stack.isEmpty() && stack.peek() != ret) {
            tmp.push(stack.pop());
        }
        if (!stack.isEmpty()) stack.pop(); // remove element == ret
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return ret;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
