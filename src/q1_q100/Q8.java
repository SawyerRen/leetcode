package q1_q100;

public class Q8 {
    public int myAtoi(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) return 0;
        boolean negative = false;
        if (s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        long res = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int val = s.charAt(index) - '0';
            res = res * 10 + val;
            if (res > Integer.MAX_VALUE) {
                if (negative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            index++;
        }
        if (negative) return -(int) res;
        else return (int) res;
    }
}
