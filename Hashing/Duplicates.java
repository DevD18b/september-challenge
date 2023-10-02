package Hashing;

public class Duplicates {

    public static int findElementWithFrequencyEquals2(int[] arr) {
        // today we are going to solve this problem using a map.

        // 1 3 4 2 2
        // s f
        int slow = arr[0];

        int fast = arr[0];
        slow = arr[slow];
        fast = arr[arr[fast]];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return fast;
    }
}
