import java.util.Deque;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    // iterative
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node prev = null;
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if (moveUp(cur, prev)) {
                ret.add(cur.val);
                stack.pop();
            } else {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
            prev = cur;
        }
        return ret;
    }

    private boolean moveUp(Node a, Node b) {
        if (a.children == null || a.children.isEmpty() || a.children.get(a.children.size() - 1).equals(b)) return true;
        return false;
    }

    // recursive
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret);
        return ret;
    }

    private void traverse(Node node, List<Integer> ret) {
        if (node == null) return;
        for (Node next : node.children) {
            traverse(next, ret);
        }
        ret.add(node.val);
    }
}
