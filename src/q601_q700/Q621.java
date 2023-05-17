package q601_q700;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            if (count[task - 'A'] > max) {
                max = count[task - 'A'];
                maxCount = 1;
            } else if (count[task - 'A'] == max) {
                maxCount++;
            }
        }
        int partCount = max - 1;
        int partLen = n - maxCount + 1;
        int remain = tasks.length - max * maxCount;
        int idle = partCount * partLen - remain;
        if (idle <= 0) return tasks.length;
        else return tasks.length + idle;
    }
}
