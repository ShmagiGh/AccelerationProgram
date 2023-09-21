import java.util.Arrays;
import java.util.Collections;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(minSplit(27));
    }

    public static int minSplit(int money) {
        Integer []coins = {1, 10, 5, 20, 50};
        Arrays.sort(coins, Collections.reverseOrder());
        return minSplitWrapper(money, coins, 0);
    }

    /*
        We can write recursive function which will add amount of highest value coins we can use so that we get
        min split, and then continue recursion on next biggest coin. It's good to keep track of coins in array,
        or some other object to make code more generalizable.
     */
    public static int minSplitWrapper(int money, Integer []coins, int coin_idx) {
        if(coin_idx >= coins.length) {
            return 0;
        }
        int coin_amount = money / coins[coin_idx];
        int money_left = money - coin_amount * coins[coin_idx];
        return coin_amount + minSplitWrapper(money_left, coins, coin_idx + 1);
    }
}
