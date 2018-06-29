class Solution {
    public int findNumberOfLIS(int[] nums) {
        int res = 0;
        int maxLen = 0;
        int[] len = new int[nums.length];
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[i]) continue;
                // same solution
                if (len[i] == len[j] + 1) {
                    cnt[i] += cnt[j];
                } else if (len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];
                }
            }

            if (maxLen == len[i]) {
                res += cnt[i];
            } else if (maxLen < len[i]) {
                maxLen = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
