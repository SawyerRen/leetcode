package q301_q400;

import java.util.LinkedList;
import java.util.Queue;

public class Q362 {
    class HitCounter {
        Queue<Integer> queue = new LinkedList<>();

        public HitCounter() {

        }

        public void hit(int timestamp) {
            queue.add(timestamp);
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
                queue.poll();
            }
            return queue.size();
        }
    }

}
