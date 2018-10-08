/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // preorder
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        // remove trailing comma
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    private int index;
    public TreeNode deserialize(String data) {
        index = 0;
        return buildTree(data.split(","));
    }

    private TreeNode buildTree(String[] nodes) {
        if (index >= nodes.length) {
            return null;
        }
        String node = nodes[index];
        index++;
        if (node.equals("#")) {
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(node));
        cur.left = buildTree(nodes);
        cur.right = buildTree(nodes);
        return cur;
    }

    // level-order, not efficient for a tree only have right nodes
    private static final TreeNode NULL_NODE = new TreeNode(Integer.MIN_VALUE);

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root == null ? NULL_NODE : root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int k = 0;
            boolean done = true;
            while (k < len) {
                int count = 0;
                while (k < len && queue.peek().val == Integer.MIN_VALUE) {
                    count++;
                    k++;
                    queue.poll();
                    // need to add left and right child for a null node
                    queue.offer(NULL_NODE);
                    queue.offer(NULL_NODE);
                }
                if (count > 0) {
                    sb.append("#");
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(",");
                } else {
                    done = false;
                    TreeNode cur = queue.poll();
                    sb.append(cur.val).append(",");
                    k++;
                    queue.offer(cur.left == null ? NULL_NODE : cur.left);
                    queue.offer(cur.right == null ? NULL_NODE : cur.right);
                }
            }
            if (done) {
                break;
            }
        }
        // remove trailing comma
        sb.deleteCharAt(sb.length() - 1);
        // remove trailing #s
        sb.setLength(sb.lastIndexOf(","));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, new TreeNode(-1)); // add dummy head at index 0
        String[] nodes = data.split(",");
        int index = 0;
        for (String node : nodes) {
            if (node.startsWith("#")) {
                index += node.length() > 1 ? Integer.parseInt(node.substring(1)) : 1;
            } else {
                index++;
                TreeNode cur = new TreeNode(Integer.parseInt(node));
                map.put(index, cur);
                TreeNode parent = map.get(index >> 1);
                if ((index & 1) == 0) {
                    parent.left = cur;
                } else {
                    parent.right = cur;
                }
            }
        }
        return map.get(0).right;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
