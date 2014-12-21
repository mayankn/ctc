package stacksnqueues;

/**
 * Created by mayanknarasimhan on 21/12/14.
 *
 * Description:
 * Write a program to retrieve the elements in a stack in ascending order (with biggest items on top).
 */
public class SortedStack extends Stack {
    Stack buffer;

    public static void main (String args[]) {
        SortedStack ss = new SortedStack();

        ss.push(4);
        ss.push(2);
        ss.push(5);
        ss.push(1);
        ss.push(3);

        System.out.println("ss: " + ss);
        System.out.println("ss.pop(): " + ss.pop());
        System.out.println("ss.pop(): " + ss.pop());
        System.out.println("ss.pop(): " + ss.pop());
    }

    public SortedStack() {
        super();
        buffer = new Stack();
    }

    public void push (int data) {
        if (!super.isEmpty()) {
            while (!super.isEmpty() && super.peek() > data)
                buffer.push(super.pop());
            super.push(data);
            while (!buffer.isEmpty())
                super.push(buffer.pop());
        } else {
            super.push(data);
        }
    }

    public int pop () {
        return super.pop();
    }

    public int peek () {
        return super.peek();
    }

    public boolean isEmpty () {
        return super.isEmpty();
    }
}
