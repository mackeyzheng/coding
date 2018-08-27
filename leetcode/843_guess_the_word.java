/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    // minimax
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new ArrayList<>(Arrays.asList(wordlist));
        Random rand = new Random();
        for (int i = 0; i < 10; i++) { // not guaranteed to find solution in 10 times
            int idx = randRange(rand, 0, words.size());
            int ans = master.guess(words.get(idx));
            if (ans == 6) break;
            shrink(words, idx, ans);
        }
    }

    private void shrink(List<String> words, int idx, int ans) {
        String word = words.get(idx);
        words.removeIf(w -> ans != match(w, word));
    }

    private int match(String a, String b) {
        int ans = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) ans++;
        }
        return ans;
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }
}
