class Solution {
    // two-pointer (deque implementation): O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0 || nums.length < k ) {
            // or throw exception
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            while (!queue.isEmpty() && queue.getFirst() < i - k + 1) {
                queue.removeFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
