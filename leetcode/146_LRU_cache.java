class LRUCache {

    private final Map<Integer, Node> map;
    private final Node head;
    private final int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        head.prev = head;
        head.next = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        detach(cur);
        attach(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // set
            Node cur = map.get(key);
            cur.val = value;
            detach(cur);
            attach(cur);
        } else {
            // add
            Node cur = new Node(key, value);
            map.put(key, cur); // register
            attach(cur); // add to list
            if (map.size() > capacity) {
                map.remove(head.prev.key); // de-register
                detach(head.prev); // remove tail node
            }
        }
    }

    private void attach(Node node) {
        Node tmp = head.next;
        head.next = node;
        node.prev = head;
        node.next = tmp;
        tmp.prev = node;
    }

    private void detach(Node node) {
        Node a = node.prev;
        Node b = node.next;
        a.next = b;
        b.prev = a;
        node.prev = null;
        node.next = null;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
