class MovingAverage {

    /** Initialize your data structure here. */
    // solution1: use deque
    // solution2: use array, update index with index % capacity
    private final Deque<Integer> queue;
    private final int capacity;
    private int sum;
    public MovingAverage(int size) {
        sum = 0;
        queue = new ArrayDeque<>();
        capacity = size;
    }

    public double next(int val) {
        if (capacity < 1) return 0;
        queue.addLast(val);
        sum += val;
        if (queue.size() > capacity) {
            sum -= queue.removeFirst();
        }
        return sum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
