// You must use only standard operations of a queue.
// Only push to back, peek/pop from front, size, and is empty operations are valid.
class MyStack {
    // private queue
    private Queue<Integer> queue = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        // add the new element and make it be the queue head 
        queue.offer(x);
        int i = queue.size() - 1;
        while (i-- > 0)
            queue.offer(queue.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
