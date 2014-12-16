package stringspaces;

/**
 * Created by mayanknarasimhan on 15/12/14.
 *
 * Description:
 * Write a method to replace all spaces in a string with'%20'.
 * You may assume that the string has sufficient space at the end of the
 * string to hold the additional characters, and that you are given the
 * "true" length of the string.
 */
public class StringSpace {
    public static void main(String args[]) {
        System.out.println(replaceSpaceWith("Mr. John Doe        "
                        .toCharArray(),
                12, "%20".toCharArray()));
        System.out.println(replaceSpaceWith1("Mr. John Doe        "
                        .toCharArray(),
                12, "%20".toCharArray()));
        System.out.println(shiftExtraSpaces("John    Doe".toCharArray()));
        System.out.println(shiftExtraSpaces("John    Doe ".toCharArray()));
        System.out.println(shiftExtraSpaces("John    Doe Smith".toCharArray()));
        System.out.println(shiftExtraSpaces("John    Doe Smith   ".toCharArray()));
        System.out.println(shiftExtraSpaces("John    Doe      Smith   ".toCharArray()));
    }

    public static char[] replaceSpaceWith(char[] str, int strLength, char[]
                                          replacement) {
        int repLength = replacement.length;
        int shiftDist = 2;
        char space = ' ';
        for(int i = 0; i < strLength; i++) {
            if(str[i] == space) {
                int start = i, end = strLength - 1;
                while (start < end) {
                    char c = str[end+shiftDist];
                    str[end+shiftDist] = str[end];
                    str[end] = c;
                    end--;
                }
                for(char c : replacement) {
                    str[start] = c;
                    start++;
                }
                strLength += 2;
            }
        }
        return str;
    }

    public static char[] replaceSpaceWith1(char[] str, int strLength, char[]
            replacement) {
        int spaceCount = 0;
        char space = ' ';

        for(int i = 0; i < strLength; i++) {
            if (str[i] == space)
                spaceCount++;
        }
        int newLength = strLength + (spaceCount*2);
        str[newLength] = '\0';

        for(int i = strLength-1; i >= 0; i--) {
            if(str[i] == space) {
                str[--newLength] = replacement[2];
                str[--newLength] = replacement[1];
                str[--newLength] = replacement[0];
            } else {
                str[newLength - 1] = str[i];
                newLength--;
            }
        }
        return str;
    }

    public static char[] shiftExtraSpaces(char[] str) {
        int strLength = str.length, extraSpace = 0;
        char space = ' ';

        for(int i = 0; i < strLength; i++) {
            if (str[i] == space) {
                if(extraSpace == 0) {
                    extraSpace++;
                    continue;
                }

                extraSpace = 0;
                int next = i, end = strLength - 1;
                while ((next < strLength) && (str[next] == space)) {
                    next++;
                }
                int start = i;
                while ((next < strLength) && str[next] != space) {
                    char c = str[start];
                    str[start] = str[next];
                    str[next] = c;
                    next++;
                    start++;
                }
            }
        }
        return str;
    }
}
