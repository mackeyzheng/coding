class Solution {

    private int[] copy;
    private int[] origin;
    private Random rand;

    public Solution(int[] nums) {
        rand = new Random();
        origin = copyOf(nums);
        copy = copyOf(nums);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        copy = copyOf(origin);
        return copyOf(origin);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // knuth shuffle
        for (int i = 0; i < copy.length; i++) {
            int j = randRange(0, i+1);
            int tmp = copy[i];
            copy[i] = copy[j];
            copy[j] = tmp;
        }
        return copy;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int[] copyOf(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
