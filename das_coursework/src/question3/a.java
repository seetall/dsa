package question3;

public class a {
    public static int maxPoints(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 2][n + 2];

        // Pad the targets with two additional elements (1) at the beginning and end
        int[] targets = new int[n + 2];
        targets[0] = targets[n + 1] = 1;
        System.arraycopy(a, 0, targets, 1, n);

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k - 1] + targets[i - 1] * targets[k] * targets[j + 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        int maxPoints = maxPoints(a);
        System.out.println("Maximum points: " + maxPoints);
    }

}
