class Solution {
    // two sum 变种
    // worst case: O(n^2)
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ret = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int s = 0;
            int e = i - 1;
            while (s < e) {
                if (nums[s] + nums[e] > nums[i]) {
                    ret += e - s;
                    e--;
                } else {
                    s++;
                }
            }
        }
        return ret;
    }

    // push k backwords as far as possible
    // worst case: O(n^2)
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ret = 0;
        Arrays.sort(nums);
        int k = 1;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (k <= j || nums[k] >= nums[i] + nums[j]) {
                    k = j;
                }
                while (k + 1 < nums.length && nums[k + 1] < nums[i] + nums[j]) {
                    k++;
                }
                ret += k - j;
            }
        }
        return ret;
    }
}
