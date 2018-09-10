/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    // inorder recursively
    private Node prev = null;
    public Node treeToDoublyList(Node root) {
        Node dh = new Node();
        prev = dh;
        traverse(root);
        if (dh.right != null) {
            prev.right = dh.right;
            dh.right.left = prev;
        }
        return dh.right;
    }

    // inorder
    private void traverse(Node node) {
        if (node == null) return;
        traverse(node.left);
        node.left = prev;
        prev.right = node;
        prev = node;
        traverse(node.right);
    }

    // inorder iteratively
    public Node treeToDoublyList(Node root) {
        Node dh = new Node();
        Deque<Node> stack = new ArrayDeque<>();
        Node prev = dh;
        pushAllLeft(root, stack);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            pushAllLeft(cur.right, stack);
            cur.left = prev;
            prev.right = cur;
            prev = cur;
        }
        if (dh.right != null) {
            prev.right = dh.right;
            dh.right.left = prev;
        }
        return dh.right;
    }

    private void pushAllLeft(Node node, Deque<Node> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
