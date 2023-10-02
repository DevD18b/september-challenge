package DpProblems;

import java.util.Arrays;

public class uniquePaths {
    public static int driverFunction(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solver(0, 0, m, n, dp);
    }

    public static int solver(int i, int j, int m, int n, int[][] dp) {

        if (i > m - 1 || j > n - 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i == m - 1) {
            return solver(i + 1, j, m, n, dp);
        }
        if (j == n - 1) {
            return solver(i, j + 1, m, n, dp);
        }
        int down = solver(i + 1, j, m, n, dp);
        int right = solver(i, j + 1, m, n, dp);
        return dp[i][j] = right + down;

    }
}
