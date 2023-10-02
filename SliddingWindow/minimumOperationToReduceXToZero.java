package SliddingWindow;

public class minimumOperationToReduceXToZero {
    public static int minimumOperation(int[] arr, int x) {

        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        int sub_array_sum_target = totalSum - x;
        ;
        int right = 0;
        int left = 0;

        int sum = 0;
        int ans = Integer.MIN_VALUE;
        while (right < arr.length) {
            sum += arr[right];
            while (left < right && sum > sub_array_sum_target) {
                sum -= arr[left];
                left++;
            }
            if (sum == sub_array_sum_target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : arr.length - ans;
    }
}
