package DpProblems;

import java.util.*;

public class targetSum {
    public static int driverMethod(int[] arr, int target) {
        int[] dp = new int[arr.length + 1];

        Arrays.fill(dp, -1);
        return solver(0, arr, target, dp);
    }

    public static int solver(int index, int[] arr, int target, int[] dp) {

        if (index >= arr.length && target != 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ans = 0;
        for (int i = index; i < arr.length; i++) {
            if (target >= arr[index]) {
                ans += solver(i + 1, arr, target - arr[i], dp);
            }
        }
        dp[index] = ans;
        return ans;

    }
}
