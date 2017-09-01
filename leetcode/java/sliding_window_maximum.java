class Solution {
    // deque: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];

        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offer(i);
            if (i >= k - 1)
                ret[ri++] = nums[deque.peek()];
        }

        return ret;
    }
}
