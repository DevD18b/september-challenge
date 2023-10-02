package DpProblems;

public class ChampagneTower {

    public static int solver(int poured, int query_Row, int query_col) {
        if (poured == 0) {
            return 0;
        }
        int[][] dp = new int[101][101];
        dp[0][0] = poured;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] >= 1) {
                    dp[i + 1][j] = dp[i + 1][j + 1] = (int) ((dp[i][j] - 1) / (2.0));
                    dp[i][j] = 1;
                }
            }
        }
        return dp[query_Row][query_col];
    }
}
