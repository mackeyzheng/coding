/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public char c;
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean hasWord;

    public TrieNode() {
        children = new HashMap<>();
        hasWord = false;
    }

    public TrieNode(char c) {
        this();
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char w = wordArray[i];
            if (curChildren.containsKey(w)) {
                cur = curChildren.get(w);
            } else {
                TrieNode newNode = new TrieNode(w);
                curChildren.put(w, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if (i == wordArray.length - 1)
                cur.hasWord = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchWordNodePos(word);
        if (node == null)
            return false;
        return node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchWordNodePos(prefix) == null ? false : true;
    }

    public TrieNode searchWordNodePos(String s) {
        Map<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }
}
