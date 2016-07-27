public class Solution {
    /**
     * Two heaps: maxHeap(left sub-tree), minHeap (right sub-tree)
     * 1. maxHeap.size == minHeap.size or maxHeap.size == minHeap.size + 1
     * 2. all elements in maxHeap is no larger than minHeap
     * 3. when maxHeap.size == minHeap.size + 1, median is maxHeap.peek()
     *    when maxHeap.size == minHeap.size, median is (maxHeap.peek() + minHeap.peek()) / 2
     *
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null) return null;
        final int N = nums.length;
        int[] res = new int[N];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(N);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
        res[0] = nums[0];
        maxHeap.offer(nums[0]);

        for (int i = 1; i < N; i++) {
            int x = maxHeap.peek();
            if (nums[i] <= x) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
