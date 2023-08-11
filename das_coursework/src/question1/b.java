package question1;

import java.util.Arrays;
public class b {
    public static int minCoins(int[] ratings) {
        int n = ratings.length;
        int[] coins = new int[n];
        Arrays.fill(coins, 1); // Initialize all riders with at least 1 coin

        // Traverse the ratings array from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                coins[i] = coins[i - 1] + 1;
            }
        }

        // Traverse the ratings array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                coins[i] = Math.max(coins[i], coins[i + 1] + 1);
            }
        }

        // Calculate the total minimum coins required
        int totalCoins = 0;
        for (int coin : coins) {
            totalCoins += coin;
        }

        return totalCoins;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int minCoinsRequired = minCoins(ratings);
        System.out.println("Minimum coins required: " + minCoinsRequired);
    }

}
