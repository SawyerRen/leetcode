package q1_q100;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String digits, int i) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(i);
        for (char next : letters[c - '0'].toCharArray()) {
            builder.append(next);
            helper(res, builder, digits, i + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}
