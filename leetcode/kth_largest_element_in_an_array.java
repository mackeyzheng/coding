class Solution {
    // time: avg O(n), worst O(n^2)  space: O(1)
    // quick select with randomized pivot
    // selection algorithm (based on the partion method - the same one as used in quicksort).
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length-1, k);
    }

    private int partition(int[] nums, int s, int e, int k) {
        if (s == e) return nums[s];
        int pivot = nums[s];
        int p = s + 1;
        int q = e;
        while (p <= q) {
            if (nums[p] >= pivot) {
                int tmp = nums[q];
                nums[q--] = nums[p];
                nums[p] = tmp;
            } else {
                p++;
            }
        }
        nums[s] = nums[q];
        nums[q] = pivot;
        int rank = e - q + 1;
        if (rank == k) return nums[q];
        if (rank < k) return partition(nums, s, q-1, k-rank);
        else return partition(nums, q+1, e, k);
    }

    // time: O(nlgk) space: O(k)
    // min-heap (priority queue)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}
