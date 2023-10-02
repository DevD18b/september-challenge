package Math;

import java.util.Arrays;

public class Candy {
    public static int candyDistributionProblem(int[] arr) {
        int total = 0;
        int[] candies = new int[arr.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        for (int i : candies) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) {

    }
}