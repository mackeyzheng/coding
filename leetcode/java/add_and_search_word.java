class WordDictionary {

    /** Initialize your data structure here. */
    public class TrieNode {
        char c;
        Map<Character, TrieNode> children;
        boolean hasWord;
        public TrieNode() {
            children = new HashMap<>();
            hasWord = false;
        }
        public TrieNode(char c) {
            this();
            this.c = c;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode(c));
            cur = cur.children.get(c);
        }
        cur.hasWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return bt(word.toCharArray(), 0, root);
    }

    private boolean bt(char[] word, int p, TrieNode node) {
        if (p == word.length) return node.hasWord;

        if (word[p] != '.') {
            return node.children.containsKey(word[p]) && bt(word, p+1, node.children.get(word[p]));
        }

        for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
            if (bt(word, p+1, child.getValue())) return true;
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
