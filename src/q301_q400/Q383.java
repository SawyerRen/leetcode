package q301_q400;

public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
            if (i < ransomNote.length()) count[ransomNote.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i < 0) return false;
        }
        return true;
    }
}
