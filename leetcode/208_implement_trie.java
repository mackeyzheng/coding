class Trie {

    class Node {
        char value;
        boolean hasWord;
        Map<Character, Node> children;
        Node() {
            hasWord = false;
            children = new HashMap<>();
        }
        Node(char value) {
            this();
            this.value = value;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;
        Node node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node(c));
            node = node.children.get(c);
        }
        node.hasWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.hasWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String s) {
        if (s == null || s.isEmpty()) return null;
        Node node = root;
        for (char c : s.toCharArray()) {
            if (!node.children.containsKey(c)) return null;
            node = node.children.get(c);
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
