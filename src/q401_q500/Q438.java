package q401_q500;

import java.util.ArrayList;
import java.util.List;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }
        int count = p.length(), i = 0, j = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            hash[rc - 'a']--;
            if (hash[rc - 'a'] >= 0) {
                count--;
            }
            while (i <= j && count == 0) {
                if (j - i + 1 == p.length()) res.add(i);
                char lc = s.charAt(i);
                hash[lc - 'a']++;
                if (hash[lc - 'a'] >= 1) {
                    count++;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
