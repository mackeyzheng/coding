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
// stack
public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        throw new RuntimeException("has no next element");
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger cur = stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return !stack.isEmpty();
    }
}

// list
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int pos;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        pos = 0;
        for (NestedInteger it : nestedList) {
            unwrap(it);
        }
    }

    private void unwrap(NestedInteger node) {
        if (node.isInteger()) {
            list.add(node.getInteger());
            return;
        }
        for (NestedInteger it : node.getList()) {
            unwrap(it);
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return list.get(pos++);
        }
        throw new RuntimeException("has no next element");
    }

    @Override
    public boolean hasNext() {
        return pos < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
