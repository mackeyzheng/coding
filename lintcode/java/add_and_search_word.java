// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
public class WordDictionary {
    // Trie Node
    class TrieNode {
        // Initialize your data structure here.
        char c;
        Map<Character, TrieNode> children;
        boolean hasWord;

        TrieNode() {
            children = new HashMap<>();
            hasWord = false;
        }

        TrieNode(char c) {
            this();
            this.c = c;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode(c));
            cur = cur.children.get(c);
        }
        cur.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root);
    }

    // helper function
    private boolean find(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.hasWord;
        }

        char c = word.charAt(index);
        if (node.children.containsKey(c)) {
            return find(word, index+1, node.children.get(c));

        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
                if (find(word, index+1, child.getValue()))
                    return true;
            }
            return false;

        }

        return false;
    }
}
