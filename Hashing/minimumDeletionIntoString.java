package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class minimumDeletionIntoString {

    public static int countDeletion(String str) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        // int count = 0;
        for (int i : map.values()) {
            int frequency = i;
            while (set.contains(frequency)) {
                count++;
                frequency--;
            }
            if (frequency > 0) {
                set.add(frequency);
            }
        }
        return count;

    }
}
