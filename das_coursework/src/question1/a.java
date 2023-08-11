package question1;

public class a {
    public static int findMinimumCost(int N, int[][] price) {
        for (int i = 1; i < N; i++) {
            // Update the minimum cost for each person based on the previous row values
            price[i][0] += Math.min(price[i - 1][1], price[i - 1][2]);
            price[i][1] += Math.min(price[i - 1][0], price[i - 1][2]);
            price[i][2] += Math.min(price[i - 1][0], price[i - 1][1]);
        }

        // The final answer will be the minimum cost in the last row
        return Math.min(Math.min(price[N - 1][0], price[N - 1][1]), price[N - 1][2]);
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] price = {{14, 4, 11}, {11, 14, 3}, {14, 2, 10}};

        int result = findMinimumCost(N, price);
        System.out.println("Minimum cost required: " + result);
    }

}
