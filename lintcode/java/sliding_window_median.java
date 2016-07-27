public class Solution {
    /**
     * O(n^2), use hash heap can reduce to O(nlgn)
     * Two heaps: maxHeap(left sub-tree), minHeap (right sub-tree)
     * 1. maxHeap.size == minHeap.size or maxHeap.size == minHeap.size + 1
     * 2. all elements in maxHeap is no larger than minHeap
     * 3. when maxHeap.size == minHeap.size + 1, median is maxHeap.peek()
     *    when maxHeap.size == minHeap.size, median is (maxHeap.peek() + minHeap.peek()) / 2
     *
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) return res;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            // add element
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            // update heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // window is full
            // delete element
            if (i >= k - 1) {
                res.add(maxHeap.peek());
                int toRemove = nums[i - k + 1];
                if (toRemove <= maxHeap.peek()) {
                    maxHeap.remove(toRemove); // delete in O(n)
                } else {
                    minHeap.remove(toRemove); // delete in O(n)
                }
                // update heaps
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }

        return res;
    }
}
