package stacksnqueues;

/**
 * Created by mayanknarasimhan on 19/12/14.
 */
public class ThreeStacksArrayDynamic {
    int size = 3;
    int numStacks = 3;
    int totalSize = size * numStacks;
    StackMetaData[] stacks = {new StackMetaData(0, size),
            new StackMetaData(size, size),
            new StackMetaData(size*2, size)};
    int[] buffer = new int[totalSize];

    public static void main (String args[]) {
        ThreeStacksArrayDynamic sa = new ThreeStacksArrayDynamic();

        sa.push(1, 1);
        sa.push(1, 2);
        sa.push(1, 3);
        sa.push(2, 1);
        sa.push(2, 2);
        sa.push(2, 3);
        sa.push(3, 1);
        sa.push(3, 2);
        sa.push(2, 4);


        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
        System.out.println(sa.pop(1) + ":"+ sa.pop(2) + ":" + sa.pop(3));
    }

    public void push (int stackNum, int data) {
        StackMetaData stack = stacks[stackNum-1];
        if (totalElements() < totalSize) {
            if (stack.size < stack.capacity) {
                stack.top = next(stack.top);
                buffer[stack.top] = data;
            } else {
                makeSpace(stackNum);
                stack.top = next(stack.top);
                buffer[stack.top] = data;
            }
            stack.size++;
        }
    }

    public void makeSpace (int stackNum) {
        StackMetaData  stack = stacks[stackNum-1];
        shift(next(stackNum-1));
        stack.capacity++;
    }

    public void shift (int stackNum) {
        StackMetaData stack = stacks[stackNum];
        if (stack.size >= stack.capacity) {
            shift(next(stackNum));
        } else {
            for (int i = (stack.beginIdx + stack.capacity - 1)%totalSize;
                    stack.isWithin(i, totalSize);
                    i = previous(i)) {
                buffer[i] = buffer[previous(i)];
            }
            buffer[stack.beginIdx] = 0;
            stack.beginIdx = next(stack.beginIdx);
            stack.top = next(stack.top);
            stack.capacity--;
        }
    }

    public int totalElements () {
        return stacks[0].size
                + stacks[1].size
                + stacks[2].size;
    }

    public int next (int idx) {
        return (idx + 1) % totalSize;
    }

    public int previous (int idx) {
        if (idx == 0)
            return totalSize - 1;
        return idx - 1;
    }

    public int pop (int stackNum) {
        int data = -1;
        StackMetaData stack = stacks[stackNum-1];
        if (stack.size > 0) {
            data = buffer[stack.top];
            stack.top = previous(stack.top);
            stack.size--;
        }
        return data;
    }

    public int seek (int stackNum) {
        int data = -1;
        if (stacks[stackNum-1].size > 0)
            data = buffer[stacks[stackNum-1].top];
        return data;
    }

    private class StackMetaData {
        int beginIdx;
        int size = 0;
        int capacity;
        int top;

        private StackMetaData (int _beginIdx, int _capacity) {
            beginIdx = _beginIdx;
            capacity = _capacity;
            top = _beginIdx - 1;
        }

        private boolean isWithin (int idx, int totalSize) {
            if (beginIdx <= idx && idx < (beginIdx+capacity)) {
                return true;
            } else if ((beginIdx+capacity) > totalSize && idx < (beginIdx+capacity)%totalSize) {
                return true;
            }
            return false;
        }
    }
}
