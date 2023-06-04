package q401_q500;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int res = 0, i = 0, j = 0;
        int maxCount = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            count[rc - 'A']++;
            maxCount = Math.max(maxCount, count[rc - 'A']);
            while (j - i + 1 > maxCount + k) {
                char lc = s.charAt(i++);
                count[lc - 'A']--;
                for (int l = 0; l < 26; l++) {
                    maxCount = Math.max(maxCount, count[l]);
                }
            }
            res = Math.max(j - i + 1, res);
            j++;
        }
        return res;
    }
}
