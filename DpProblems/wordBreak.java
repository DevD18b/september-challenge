package DpProblems;

import java.util.*;

public class wordBreak {
    public static boolean targetExist(String target, String[] wordDictionary) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDictionary) {
            set.add(word);
        }
        return solver(0, target, set);
    }

    public static boolean solver(int index, String target, HashSet<String> wordDictionary) {

        if (index == target.length())
            return false;

        for (int i = index; i < target.length(); i++) {
            if (wordDictionary.contains(target.substring(index, i + 1)) && solver(i + 1, target, wordDictionary)) {
                return true;
            }
        }
        return false;

    }
}