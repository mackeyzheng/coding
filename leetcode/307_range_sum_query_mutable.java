class NumArray {

    private int[] data;
    private int[] bit;

    public NumArray(int[] nums) {
        // build BIT
        data = new int[nums.length];
        bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int delta = val - data[i];
        data[i] = val;
        i++;
        while (i <= data.length) {
            bit[i] += delta;
            i += i & (-i);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    private int sum(int endIndex) {
        int sum = 0;
        endIndex++;
        while (endIndex > 0) {
            sum += bit[endIndex];
            endIndex -= endIndex & (-endIndex);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
