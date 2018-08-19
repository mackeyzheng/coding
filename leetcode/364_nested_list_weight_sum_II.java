import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    // bfs
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weighted = 0;
        int unweighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    unweighted += ni.getInteger();
                } else {
                    nextLevel.addAll(ni.getList());
                }
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }

    // dfs
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        dfs(nestedList, 1, ret);
        int sum = 0;
        for (int i = 0; i < ret.size(); i++) {
            sum += ret.get(i) * (ret.size() - i);
        }
        return sum;
    }

    private void dfs(List<NestedInteger> list, int level, List<Integer> ret) {
        if (level >= ret.size())
            ret.add(0);
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                ret.set(level, ret.get(level) + ni.getInteger());
            } else {
                dfs(ni.getList(), level + 1, ret);
            }
        }
    }
}
