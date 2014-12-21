package stacksnqueues;

/**
 * Created by mayanknarasimhan on 21/12/14.
 *
 * Description:
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items,
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class StackSort extends Stack {
    Stack buffer;

    public static void main (String args[]) {
        StackSort ss = new StackSort();

        ss.push(4);
        ss.push(2);
        ss.push(5);
        ss.push(1);
        ss.push(3);

        System.out.println("ss: " + ss);

        ss.sort();

        System.out.println("ss: " + ss);
    }

    public StackSort () {
        super();
        buffer = new Stack();
    }

    public void sort () {
        while (!super.isEmpty()) {
            int tmp = super.pop();
            while (!buffer.isEmpty() && tmp > buffer.peek()) {
                super.push(buffer.pop());
            }
            buffer.push(tmp);
        }

        while (!buffer.isEmpty())
            super.push(buffer.pop());
    }
}
