public class Solution {
    // deque: tiem O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!deque.isEmpty() && cur > deque.peekLast())
                deque.pollLast();

            deque.offer(cur);

            if (i < k - 1)
                continue;

            int index = i - k + 1;
            res[index] = deque.peekFirst();
            if (res[index] == nums[index])
                deque.pollFirst();
        }

        return res;
    }
}
