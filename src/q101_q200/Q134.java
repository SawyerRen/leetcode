package q101_q200;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return -1;
        int start = 0;
        int cur = 0;
        for (int i = 0; i < cost.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
