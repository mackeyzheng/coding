class MyQueue {

    /** Initialize your data structure here. */
    // using two stacks
    // all ops is O(1) time amortized
    
    private Deque<Integer> head;
    private Deque<Integer> tail;

    public MyQueue() {
        head = new LinkedList<>();
        tail = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        tail.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return head.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (head.isEmpty()) {
            while (!tail.isEmpty())
                head.push(tail.pop());
        }
        return head.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
