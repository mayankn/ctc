package arraysnstrings;


/**
 * Created by mayanknarasimhan on 15/12/14.
 *
 * Description:
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string.
 */
public class StringCompress {
    public static void main (String args[]) {
        String[] testWords = {"test", "aabcccccaaa", "dog", "aaaab"};
        for (String w : testWords)
            System.out.println(compressString(w));
    }

    public static String compressString(String str) {
        int strLength = str.length();
        if (strLength < 2)
            return str;
        int newSize = compressedSize(str);
        if (strLength <= newSize)
            return str;

        StringBuilder sb = new StringBuilder();
        int counter = 1;
        char c = str.charAt(0);
        for (int i = 1; i < strLength; i++) {
            if(str.charAt(i) == c)
                counter++;
            else {
                sb.append(c);
                sb.append(counter);
                c = str.charAt(i);
                counter = 1;
            }
        }
        sb.append(c);
        sb.append(counter);
        String newStr = sb.toString();
        return newStr.length() < strLength ? newStr : str;
    }



    public static int compressedSize (String str) {
        int counter = 1, strLength = str.length(), size = 0;
        char c = str.charAt(0);
        for (int i = 1; i < strLength; i++) {
            if(str.charAt(i) == c)
                counter++;
            else {
                size += 1;
                size += String.valueOf(counter).length();
                c = str.charAt(i);
                counter = 1;
            }
        }
        size += 1;
        size += String.valueOf(counter).length();
        return size;
    }
}
