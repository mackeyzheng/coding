/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return nestedList == null ? 0 : dfs(1, nestedList);
    }

    private int dfs(int level, List<NestedInteger> list) {
        int sum = 0;
        for (NestedInteger item : list) {
            if (item.isInteger())
                sum += item.getInteger() * level;
            else
                sum += dfs(level + 1, item.getList());
        }
        return sum;
    }
}
