package permutation;

import java.util.HashMap;

/**
 * Created by mayanknarasimhan on 15/12/14.
 *
 * Description:
 * Given two strings, write a method to decide, if one is a permutation of
 * the other.
 */
public class PermutationCheck {
    public static void main (String args[]) {
        System.out.println(isPermutation("god", "dog"));
        System.out.println(isPermutation("god  ", "dog"));
        System.out.println(isPermutation("god is dog", "dog is god"));
        System.out.println(isPermutation("good", "dogo"));
        System.out.println(isPermutation("goods", "dogoo"));
    }

    public static boolean isPermutation(String str1, String str2) {
        int str1Length = str1.length(), str2Length = str2.length();
        if(str1Length != str2Length)
            return false;

        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        for(int i = 0; i < str1Length; i++) {
            if(!map1.containsKey(str1.charAt(i)))
                map1.put(str1.charAt(i), 1);
            else
                map1.put(str1.charAt(i), map1.get(str1.charAt(i)) + 1);
        }

        for(int i = 0; i < str2Length; i++) {
            if(!map1.containsKey(str2.charAt(i)))
                return false;
            else {
                map1.put(str2.charAt(i), map1.get(str2.charAt(i)) - 1);
                if(map1.get(str2.charAt(i)) < 0)
                    return false;
            }

        }
        return true;
    }
}
