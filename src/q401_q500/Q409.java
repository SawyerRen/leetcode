package q401_q500;

public class Q409 {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean odd = false;
        int res = 0;
        for (int i : count) {
            if (i % 2 != 0) odd = true;
            res += i / 2 * 2;
        }
        return odd ? res + 1 : res;
    }
}
