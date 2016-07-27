public class MedianFinder {

    /*
     * Two heaps: maxHeap(left sub-tree), minHeap (right sub-tree)
     * 1. maxHeap.size == minHeap.size or maxHeap.size == minHeap.size + 1
     * 2. all elements in maxHeap is no larger than minHeap
     * 3. when maxHeap.size == minHeap.size + 1, median is maxHeap.peek()
     */

    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
        @Override
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }

        int cur = maxHeap.peek();
        if (cur >= num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return maxHeap.size() == minHeap.size() ? 1.0 * (maxHeap.peek() + minHeap.peek()) / 2 : 1.0 * maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
