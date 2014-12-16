package arraysnstrings;

import java.util.HashMap;

/**
 * Created by mayanknarasimhan on 15/12/14.
 *
 * Description:
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class UniqueChars {
    public static void main (String args[]) {
        String[] testWords = {"hello", "test", "simple", "duplicate", "error"};
        for (String w : testWords)
            System.out.println(isUnique1(w) + ":" + isUnique2(w) + ":" +
                    isUnique2(w));
    }

    public static boolean isUnique1(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            if (map.containsKey(str.charAt(i)))
                return false;
            else
                map.put(str.charAt(i), 1);
        }
        return true;
    }

    public static boolean isUnique2(String str) {
        int strLength = str.length(), val = 0;
        if (strLength > 128)
            return false;

        boolean[] unique = new boolean[128];
        for (int i = 0; i < strLength; i++) {
            val = str.charAt(i);
            if (unique[val])
                return false;
            else
                unique[val] = true;
        }
        return true;
    }

    public static boolean isUnique3(String str) {
        int strLength = str.length(), checker = 0, charPos;
        if (strLength > 32)
            return false;
        str = str.toLowerCase();
        for (int i = 0; i < strLength; i++) {
            charPos = str.charAt(i) - 'a';
            int marker = (1 << charPos);
            if((checker & marker) > 0)
                return false;
            checker |= marker;
        }
        return true;
    }
}
