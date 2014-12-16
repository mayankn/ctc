package reverse;

/**
 * Created by mayanknarasimhan on 15/12/14.
 *
 * Description:
 * Implement a function which reverses a null- terminated string
 */
public class Reverse {
    public static void main(String args[]) {
        String[] testWords = {"hello", "test", "error", "i am hello world"};
        for (String w : testWords) {
            System.out.print(w + " --> " + strReverse(w) + ":");
            System.out.print(strReverseInPlace(w.toCharArray()));
            System.out.print(":");
            System.out.println(strReverseRecurse(w.toCharArray(), 0, w
                    .length() - 1));
        }
    }

    public static String strReverse(String str) {
        int strLength = str.length();
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < strLength; i++) {
            newStr.append(str.charAt((strLength-1)-i));
        }
        return newStr.toString();
    }

    public static char[] strReverseInPlace(char[] charArr) {
        int strLength = charArr.length;
        for(int i = 0, j = strLength-1; i < strLength/2; i++, j--) {
            char c = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = c;
        }
        return charArr;
    }

    public static char[] strReverseRecurse(char[] str, int from, int to) {
        while (from < to) {
            char c = str[from];
            str[from] = str[to];
            str[to] = c;
            return strReverseRecurse(str, ++from, --to);
        }
        return str;
    }
}
