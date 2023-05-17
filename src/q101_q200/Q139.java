package q101_q200;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

