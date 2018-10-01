class Solution {

    private final int[] array;
    private final Random rand;

    public Solution(int[] w) {
        rand = new Random();
        array = new int[w.length];
        array[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            array[i] = array[i - 1] + w[i]; // accumulate - prefix sum
        }
    }

    public int pickIndex() {
        // binary search the smallest weight that is equal or larger than random pick target
        int target = rand.nextInt(array[array.length - 1]) + 1;
        int s = 0;
        int e = array.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (array[m] < target) {
                s = m + 1;
            } else if (array[m] > target) {
                e = m - 1;
            } else {
                return m;
            }
        }
        return s;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
