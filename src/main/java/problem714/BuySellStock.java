package problem714;

public final class BuySellStock {

    public int maxProfit(final int[] prices, final int fee) {
        int buy = 0;
        int sell = Integer.MIN_VALUE / 2;
        for (final int p : prices) {
            buy = Math.max(buy, sell + p);
            sell = Math.max(sell, buy - p - fee);
        }
        return buy;
    }

}
