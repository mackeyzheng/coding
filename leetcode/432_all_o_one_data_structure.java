class AllOne {

    // bucket node
    private class Node {
        int count;
        Set<String> keySet;
        Node next;
        Node pre;
        Node(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }
    }

    private final Map<String, Integer> keyCount;
    private final Map<Integer, Node> countNode;
    private final Node head;

    /** Initialize your data structure here. */
    public AllOne() {
        keyCount = new HashMap<>();
        countNode = new HashMap<>();
        head = new Node(0);
        head.next = head;
        head.pre = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCount.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCount.put(key, 1);
            if (!countNode.containsKey(1)) {
                countNode.put(1, new Node(1));
                attachBefore(countNode.get(1), head); // attach node 1 between head.pre (tail) and head
            }
            countNode.get(1).keySet.add(key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCount.containsKey(key)) {
            int count = keyCount.get(key);
            if (count == 1) {
                keyCount.remove(key);
                removeKeyFromBucket(countNode.get(count), key);
            } else {
                changeKey(key, -1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return !countNode.isEmpty() ? head.next.keySet.iterator().next() : "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return !countNode.isEmpty() ? head.pre.keySet.iterator().next() : "";
    }

    private void changeKey(String key, int delta) {
        int count = keyCount.get(key);
        // update keyCount map
        keyCount.put(key, count + delta);
        // update countNode map
        Node cur = countNode.get(count);
        Node update;
        if (countNode.containsKey(count + delta)) {
            update = countNode.get(count + delta);
        } else {
            // add new bucket node
            update = new Node(count + delta);
            countNode.put(count + delta, update);
            attachBefore(update, delta > 0 ? cur : cur.next);
        }
        update.keySet.add(key);
        removeKeyFromBucket(cur, key);
    }

    private void removeKeyFromBucket(Node node, String key) {
        node.keySet.remove(key);
        if (node.keySet.isEmpty()) {
            detach(node); // remove bucket node from list
            countNode.remove(node.count);
        }
    }

    private void detach(Node node) {
        Node a = node.pre;
        Node b = node.next;
        a.next = b;
        b.pre = a;
        node.pre = null;
        node.next = null;
    }

    // attach node before cur
    private void attachBefore(Node node, Node cur) {
        Node tmp = cur.pre;
        tmp.next = node;
        node.pre = tmp;
        node.next = cur;
        cur.pre = node;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
