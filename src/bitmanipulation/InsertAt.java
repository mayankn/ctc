package bitmanipulation;

/**
 * Created by mayanknarasimhan on 28/12/14.
 *
 * Description:
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not,for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N=10000000000, M=10011, i=2, j=6
 * Output:N = 10001001100
 */
public class InsertAt {
    public static void main (String args[]) {
        int n = 1024, m = 9;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(insertNumAtBit(n, m, 3, 6)));
        System.out.println(Integer.toBinaryString(insertNumAtBitAlt(n, m, 3, 6)));
    }

    public static int insertNumAtBit (int n, int m, int i, int j) {
        int idx = i;
        while (idx <= j) {
            n = clearBit(n, idx);
            idx++;
        }
        return n | (m << i);
    }

    public static int clearBit (int num, int i) {
        return num & ~(1 << i);
    }

    public static int insertNumAtBitAlt (int n, int m, int i, int j) {
        int allOnes = ~0;
        int leftZeroes = allOnes << (j + 1);
        int rightZeroes = (allOnes << i) - 1;
        int mask = leftZeroes | rightZeroes;
        return (n & mask) | (m << i);
    }
}
