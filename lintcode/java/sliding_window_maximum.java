public class Solution {
    /**
     * Deque: siliding window -> add one, then delete one
     * time: O(n)  space: O(k)
     *
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // add one
            while (!deque.isEmpty() && cur > deque.peekLast()) {
                deque.pollLast();
            }

            deque.offer(cur);

            // delete one
            if (i < k - 1)
                continue;

            res.add(deque.peekFirst());
            if (deque.peekFirst() == nums[i-k+1])
                deque.pollFirst();
        }

        return res;
    }
}
