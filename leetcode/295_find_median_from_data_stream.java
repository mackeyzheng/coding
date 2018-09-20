class MedianFinder {

    /** initialize your data structure here. */

    /*
     * Two heaps: maxHeap(left sub-tree), minHeap (right sub-tree)
     * 1. maxHeap.size == minHeap.size or maxHeap.size == minHeap.size + 1
     * 2. all elements in maxHeap is no larger than minHeap
     * 3. when maxHeap.size == minHeap.size + 1, median is maxHeap.peek()
     *
     * Instead of PriorityQueue (Heap), can also use a BST
     */
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(1, (a, b) -> b - a); // Collections.reverseOrder()
        minHeap = new PriorityQueue<>();
    }

    // O(lgn)
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    // public void addNum(int num) {
    //     if (minHeap.isEmpty() || minHeap.peek() <= num) {
    //         minHeap.offer(num);
    //     } else {
    //         maxHeap.offer(num);
    //     }
    //     if (maxHeap.size() > minHeap.size()) {
    //         minHeap.offer(maxHeap.poll());
    //     }
    //     if (minHeap.size() > maxHeap.size() + 1) {
    //         maxHeap.offer(minHeap.poll());
    //     }
    // }

    // O(1)
    public double findMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            throw new RuntimeException("empty");
        }
        return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
