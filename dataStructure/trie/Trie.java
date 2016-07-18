/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */

// Trie Node
class TrieNode {
    // Initialize your data structure here.
    char c;
    Map<Character, TrieNode> children;
    boolean hasWord;
    String word;

    TrieNode() {
        children = new HashMap<>();
        hasWord = false;
        word = "";
    }

    TrieNode(char c) {
        this();
        this.c = c;
    }
}

// Trie: tree of TrieNode
class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode(c));
            cur = cur.children.get(c);
        }
        cur.hasWord = true;
        cur.word = word;
    }

    // Returns if the word is in the trie.
    boolean search(String word) {
        TrieNode node = searchWordNodePos(word);
        if (node == null)
            return false;
        return node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    boolean startsWith(String prefix) {
        return searchWordNodePos(prefix) == null ? false : true;
    }

    TrieNode searchWordNodePos(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (!cur.children.containsKey(c))
                return null;
            cur = cur.children.get(c);
        }
        return cur;
    }
}
