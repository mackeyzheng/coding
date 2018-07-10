class Solution {
    // stack: try to construct the BST, use stack to store parents, using to do backtracking from child nodes
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }

        int low = Integer.MIN_VALUE;
        Deque<Integer> stack =  new ArrayDeque<>();
        for (int value : preorder) {
            if (value < low) {
                return false;
            }
            while (!stack.isEmpty() && value > stack.peek()) {
                low = stack.pop();
            }
            stack.push(value);
        }

        return true;
    }

    // dfs + backtracking
    public boolean verifyPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(int[] preorder, int start, int end, int min, int max) {
        if (start > end) {
            return true;
        }

        // verify root
        int root = preorder[start];
        if (root <= min || root >= max) {
            return false;
        }

        // identify the boundary of sub problems
        int mid = start;
        while (mid <= end && preorder[mid] <= root) {
            mid++;
        }
        return dfs(preorder, start+1, mid-1, min, root) && dfs(preorder, mid, end, root, max);
    }
}
