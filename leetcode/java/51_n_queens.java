class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(n, 0, new int[n], res);
        return res;
    }

    private void dfs(int n, int row, int[] queens, List<List<String>> res) {
        if (row == n) {
            res.add(generate(queens));
            return;
        }
        for (int i = 0; i < n; i++) {
            queens[row] = i;
            if (isValid(row, queens)) {
                dfs(n, row+1, queens, res);
            }
        }
    }

    private boolean isValid(int row, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row] || Math.abs(queens[row] - queens[i]) == row - i) {
                return false;
            }
        }
        return true;
    }

    private List<String> generate(int[] queens) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                sb.append(".");
            }
            sb.setCharAt(queens[i], 'Q');
            res.add(sb.toString());
        }
        return res;
    }
}
