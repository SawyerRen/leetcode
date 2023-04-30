package q801_q900;

public class Q844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (s1.length() > 0) s1.setLength(s1.length() - 1);
            } else {
                s1.append(c);
            }
        }
        StringBuilder t1 = new StringBuilder();
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (t1.length() > 0) t1.setLength(t1.length() - 1);
            } else {
                t1.append(c);
            }
        }
        return s1.toString().equals(t1.toString());
    }
}
