package q101_q200;

public class Q121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            res = Math.max(res, price - minPrice);
        }
        return res;
    }
}
