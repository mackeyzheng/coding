class AllOne {

    /** Initialize your data structure here. */
    class Node {
        int count;
        Set<String> keys;
        Node prev;
        Node next;

        Node(int _count) {
            count = _count;
            keys = new HashSet<>();
        }
    }

    private final Map<String, Node> map;
    private final Node head;

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        head.prev = head;
        head.next = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.keys.remove(key);
            if (old.next.count != old.count + 1) {
                Node newNode = new Node(old.count + 1);
                newNode.keys.add(key);
                attachAfter(newNode, old);
            } else {
                old.next.keys.add(key);
            }
            // update register info
            map.put(key, old.next);
            if (old.keys.isEmpty()) {
                detach(old);
            }
        } else {
            if (head.next.count != 1) {
                attachAfter(new Node(1), head);
            }
            head.next.keys.add(key);
            // update register info
            map.put(key, head.next);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node old = map.get(key);
        old.keys.remove(key);
        if (old.count == 1) {
            // update register info
            map.remove(key);
        } else {
            if (old.prev.count != old.count - 1) {
                Node newNode = new Node(old.count - 1);
                newNode.keys.add(key);
                attachAfter(newNode, old.prev);
            } else {
                old.prev.keys.add(key);
            }
            // update register info
            map.put(key, old.prev);
        }
        if (old.keys.isEmpty()) {
            detach(old);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return map.isEmpty() ? "" : head.prev.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return map.isEmpty() ? "" : head.next.keys.iterator().next();
    }

    // attach a between b and b.next
    private void attachAfter(Node a, Node b) {
        a.prev = b;
        a.next = b.next;
        b.next.prev = a;
        b.next = a;
    }

    private void detach(Node a) {
        Node prev = a.prev;
        Node next = a.next;
        prev.next = next;
        next.prev = prev;
        a.prev = null;
        a.next = null;
    }
}

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
