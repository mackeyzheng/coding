class Solution {
    // dfs
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return nums.length == 0 && k == 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        return canPartition(nums, 0, k, 0, 0, sum / k, new boolean[nums.length]);
    }

    // curLen is to avoid empty subset when curSum is 0
    private boolean canPartition(int[] nums, int pos, int k, int curSum, int curLen, int target, boolean[] visited) {
        // the remaining elements are the last set
        if (k == 1) {
            return true;
        }

        // find a set sums to target
        if (curSum == target && curLen > 0) {
            // find next set from the start point of the nums array
            return canPartition(nums, 0, k - 1, 0, 0, target, visited);
        }

        // find next element for the current set from pos position
        for (int i = pos; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (canPartition(nums, i + 1, k, curSum + nums[i], curLen + 1, target, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
