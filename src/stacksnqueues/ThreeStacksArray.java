package stacksnqueues;

/**
 * Created by mayanknarasimhan on 19/12/14.
 *
 * Description:
 * Describe how you could use a single array to implement three stacks
 */
public class ThreeStacksArray {
    int[] stacks;
    int size = 3;
    int totalSize = size * 3;
    int[] ptrs = {-1, -1, -1};

    public static void main (String args[]) {
        ThreeStacksArray sa = new ThreeStacksArray();

        sa.push(1, 1);
        sa.push(2, 1);
        sa.push(3, 1);
        sa.push(1, 2);
        sa.push(2, 2);
        sa.push(3, 2);
        sa.push(1, 3);
        sa.push(2, 3);
        sa.push(3, 3);

        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
    }

    public ThreeStacksArray () {
        stacks = new int[size * 3];
    }

    public void push (int stackNum, int data) {
        if (ptrs[stackNum-1] < size) {
            ptrs[stackNum-1] = ptrs[stackNum-1] + 1;
            stacks[(size * (stackNum - 1)) + ptrs[stackNum-1]] = data;
        }
    }

    public int pop (int stackNum) {
        int data = -1;
        if (ptrs[stackNum-1] != -1) {
            data = stacks[(size * (stackNum - 1)) + ptrs[stackNum-1]];
            ptrs[stackNum-1] = ptrs[stackNum-1] - 1;;
        }
        return data;
    }

    public int seek (int stackNum) {
        int data = -1;
        if (ptrs[stackNum-1] >= ((stackNum-1) * totalSize)/3) {
            data = stacks[(size * (stackNum - 1)) + ptrs[stackNum-1]];
        }
        return data;
    }
}
