package q201_q300;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            count[c1 - 'a']++;
            count[c2 - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}
