package DpProblems;

import java.util.Arrays;
import java.util.Comparator;

public class StringChain {

    public static int longestStringChainPredecessor(String[] words) {

        Comparator<String> lengthComparator = (str1, str2) -> Integer.compare(str1.length(), str2.length());

        Arrays.sort(words, lengthComparator);

        return lis(-1, 0, words);
    }

    public static int lis(int prev, int index, String[] arr) {
        if (index >= arr.length) {
            return 0;
        }
        int take = 0;
        int not_take = 0;

        if (prev == -1 || isPredeccessor(arr[prev], arr[index])) {
            take = 1 + lis(index, index + 1, arr);
        }
        not_take = lis(prev, index + 1, arr);

        return Math.max(take, not_take);
    }

    public static boolean isPredeccessor(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();

        if (len1 >= len2 && len1 - len2 != 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == a.length();

    }

}
