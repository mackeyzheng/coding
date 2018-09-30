class MaxStack {

    // TreeMap + Doubly Linked List
    // TreeMap acts like a priority queue, but it provides O(logN) write
    // Doubly Linked List provides O(1) push() and pop()

    /** initialize your data structure here. */
    class Node {
        int val;
        Node prev;
        Node next;
        Node (int _val) {
            val = _val;
        }
    }

    // use LinkedList, since it only uses append and removeLast, no random access
    private final TreeMap<Integer, LinkedList<Node>> map;
    private final Node head;

    public MaxStack() {
        map = new TreeMap<>();
        head = new Node(0);
        head.next = head;
        head.prev = head;
    }

    public void push(int x) {
        Node node = new Node(x);
        map.computeIfAbsent(x, v -> new LinkedList<>()).add(node);
        attach(node);
    }

    public int pop() {
        if (map.isEmpty()) {
            throw new RuntimeException("empty");
        }
        int key = head.next.val;
        // remove last, it is guaranteed to be head.next
        map.get(key).removeLast();
        if (map.get(key).isEmpty()) {
            map.remove(key);
        }
        detach(head.next);
        return key;
    }

    public int top() {
        if (map.isEmpty()) {
            throw new RuntimeException("empty");
        }
        return head.next.val;
    }

    public int peekMax() {
        if (map.isEmpty()) {
            throw new RuntimeException("empty");
        }
        return map.lastKey();
    }

    public int popMax() {
        if (map.isEmpty()) {
            throw new RuntimeException("empty");
        }
        int key = map.lastKey();
        Node node = map.get(key).removeLast();
        if (map.get(key).isEmpty()) {
            map.remove(key);
        }
        detach(node);
        return key;
    }

    private void attach(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void detach(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    // stack, popMax is O(n)
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

    // O(n)
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
