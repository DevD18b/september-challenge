package Strings;

import java.util.*;

public class RemoveDuplicatesInString {
    public static String lexicoGraphicallyUniqueString(String str) {

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[str.length()];
        int[] lastSeenIndex = new int[str.length()];

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            lastSeenIndex[ch - 'a'] = i;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            int index = ch - 'a';
            visited[index] = true;
            while (sb.length() > 0 && ch < sb.charAt(stack.peek())
                    && lastSeenIndex[sb.charAt(stack.peek()) - 'a'] > i) {
                sb.deleteCharAt(stack.peek());
                stack.pop();
            }
            sb.append(ch);
            stack.push(index);
        }
        return sb.toString();
    }

}
