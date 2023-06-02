package q201_q300;

public class Q211 {
    class WordDictionary {
        class Node {
            boolean isWord = false;
            Node[] children = new Node[26];
        }

        Node root = new Node();

        public WordDictionary() {

        }

        public void addWord(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            Node cur = root;
            return helper(cur, word, 0);
        }

        private boolean helper(Node cur, String word, int index) {
            if (index == word.length()) return cur.isWord;
            char c = word.charAt(index);
            if (c != '.') {
                if (cur.children[c - 'a'] == null) return false;
                return helper(cur.children[c - 'a'], word, index + 1);
            }
            boolean res = false;
            for (Node child : cur.children) {
                if (child != null) {
                    res |= helper(child, word, index + 1);
                }
            }
            return res;
        }
    }
}
