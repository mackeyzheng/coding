class Solution {
    // bottom-up dp
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1); // initialize to no solution
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) break;
                if (dp[i-coin] == -1) continue; // important
                dp[i] = dp[i] == -1 ? dp[i-coin]+1 : Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount];
    }

    // top-down dp
    // theoretically, top-down is faster than bottom-up here,
    // because it does not need to iterate all nodes in the tree
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2); // -2: no calculation, -1: no result
        memo[0] = 0; // terminal condition
        return getMemo(amount, memo, coins);
    }

    private int getMemo(int amount, int[] memo, int[] coins) {
        if (amount < 0) return -1;
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int result = -1;
        for (int coin : coins) {
            if (amount < coin) break; // can break here, since coins is sorted
            int temp = getMemo(amount - coin, memo, coins);
            if (temp != -1 && (result == -1 || temp + 1 < result)) {
                result = temp + 1;
            }
        }
        return memo[amount] = result;
    }

    // dfs + greedy
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
