package DpProblems;

import java.util.HashSet;

public class missingWordInDictionary {
    public static int missingCharacter(String str, String[] dictionary) {

        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }

        return solver(0, str, set);
    }

    public static int solver(int index, String target, HashSet<String> set) {

        if (index == target.length()) {
            return 0;
        }

        int ifCharacterMissed = 1 + solver(index + 1, target, set);
        for (int i = index; i < target.length(); i++) {
            String sub_str = target.substring(index, i + 1);
            if (set.contains(sub_str)) {
                ifCharacterMissed = Math.min(ifCharacterMissed, solver(i + 1, target, set));
            }
        }
        return ifCharacterMissed;
    }

}
