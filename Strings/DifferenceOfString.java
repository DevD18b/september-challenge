package Strings;

public class DifferenceOfString {
    public static char findTheMissing(String str, String t) {
        int[] freq = new int[26];
        for (char ch : t.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']--;
        }
        char ans = ' ';
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                ans = (char) (i + 'a');
                break;
            }
        }
        return ans;
    }
}
