class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        helper(coins, coins.length - 1, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int min = Integer.MAX_VALUE;

    private void helper(int[] coins, int cur, int amount, int count) {
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        }
        if (cur < 0 || amount < 0 || min < count) return;
        for (int freq = amount / coins[cur]; freq >= 0; freq--) {
            if (count + freq > min) break;
            helper(coins, cur - 1, amount - (coins[cur] * freq), count + freq);
        }
    }
}
