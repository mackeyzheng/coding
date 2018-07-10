import java.util.AbstractMap.SimpleEntry;

public class LRUCache {
    // simple solution1: use LinkedHashMap
    // solution2: use HashMap and LinkedList, but this will exceed time limit
//    public class LRUNode {
//        int key;
//        int value;
//        public LRUNode(int x, int y) {
//            key = x;
//            value = y;
//        }
//    }
//
//    private int capacity;
//    private Map<Integer, LRUNode> map;
//    private List<LRUNode> list;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<Integer, LRUNode>();
//        list = new LinkedList<LRUNode>();
//    }
//
//    public int get(int key) {
//        int ret = -1;
//        LRUNode node = map.get(key);
//        if (node != null) {
//            ret = node.value;
//            updateList(node);
//        }
//        return ret;
//    }
//
//    public void set(int key, int value) {
//        LRUNode node = map.get(key);
//        if (node != null) {
//            node.value = value;
//            updateList(node);
//        } else {
//            if (list.size() == this.capacity) {
//                LRUNode delete_node = list.remove(list.size() - 1);
//                map.remove(delete_node.key);
//            }
//            LRUNode new_node = new LRUNode(key, value);
//            list.add(0, new_node);
//            map.put(key, new_node);
//        }
//    }
//
//    private void updateList(LRUNode node) {
//        // put node to the head of this list
//        list.remove(node);  // O(n), exceed time limit
//        list.add(0, node);
//    }

    // solution3: use HashMap, and a self-modified double linked list
    public class DoubleLinkedNode {
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        SimpleEntry<Integer, Integer> entry;
        public DoubleLinkedNode(int key, int value) {
            prev = null;
            next = null;
            entry = new SimpleEntry<Integer, Integer>(key, value);
        }
    }

    private int capacity;
    private Map<Integer, DoubleLinkedNode> map;
    private DoubleLinkedNode head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DoubleLinkedNode>();
        head = null;
    }

    public int get(int key) {
        int ret = -1;
        DoubleLinkedNode node = map.get(key);
        if (node != null) {
            ret = node.entry.getValue();
            // refresh the list
            detach(node);
            attach(node);
        }
        return ret;
    }

    public void set(int key, int value) {
        DoubleLinkedNode node = map.get(key);
        if (node != null) {
            node.entry.setValue(value);
            detach(node);
            attach(node);
        } else {
            if (map.size() == this.capacity) {
                // remove the last node
                map.remove(head.prev.entry.getKey());
                detach(head.prev);
            }
            DoubleLinkedNode new_node = new DoubleLinkedNode(key, value);
            attach(new_node);
            map.put(key, new_node);
        }
    }

    // remove node from the list
    private void detach(DoubleLinkedNode node) {
        // update head
        if (head == node) head = head.next;
        if (head == node) { // the list just has one node, and it is exact the node to be removed
            head = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    // attach the node to the list head
    private void attach(DoubleLinkedNode node) {
        // notice head
        if (head != null) {
            node.next = head;
            node.prev= head.prev;
            head.prev = node;
            node.prev.next = node;
        } else {
            node.prev = node;
            node.next = node;
        }
        head = node;
    }

}
