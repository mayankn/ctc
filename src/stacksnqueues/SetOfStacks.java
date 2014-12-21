package stacksnqueues;

import linkedlist.Node;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by mayanknarasimhan on 21/12/14.
 *
 * Description:
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure, SetOf Stacks that mimics this.
 * SetOf Stacks should be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave
 * identically to a single stack (that is, pop() should return the same values as it would
 * if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class SetOfStacks {
    int threshold;
    Stack topStack;
    ArrayList<Stack> stacks;

    public static void main (String args[]) {
        SetOfStacks sos = new SetOfStacks(3);

        sos.push(1);
        sos.push(2);
        sos.push(3);
        sos.push(4);
        sos.push(5);
        sos.push(6);
        sos.push(7);
        sos.push(8);
        sos.push(9);

        System.out.println("sos.pop(): " + sos.pop());
        System.out.println("sos.pop(): " + sos.pop());
        System.out.println("sos.pop(): " + sos.pop());
        System.out.println("sos.pop(): " + sos.pop());
        System.out.println("sos.pop(): " + sos.pop());
        System.out.println("sos.pop(): " + sos.pop());
        System.out.println("sos.pop(): " + sos.pop());

        sos.push(3);
        sos.push(4);
        sos.push(5);
        sos.push(6);
        sos.push(7);
        sos.push(8);
        sos.push(9);

        System.out.println("sos.pop(0): " + sos.popAt(0));
        System.out.println("sos.pop(0): " + sos.popAt(0));
        System.out.println("sos.pop(1): " + sos.popAt(1));
        System.out.println("sos.pop(1): " + sos.popAt(1));
        //System.out.println("sos.pop(2): " + sos.popAt(2));
    }

    public SetOfStacks (int _threshold) {
        threshold = _threshold;
        topStack = new Stack();
        stacks = new ArrayList<Stack>();
    }

    public void push (int data) {
        if (stacks.size() == 0) {
            Stack s = new Stack();
            s.push(data);
            stacks.add(s);
            topStack.push(0);
        } else {
            int stackOnTop = topStack.peek();
            Stack s = stacks.get(stackOnTop);
            if (s.size() < threshold)
                s.push(data);
            else {
                Stack newStack = new Stack();
                newStack.push(data);
                stacks.add(newStack);
                topStack.push(++stackOnTop);
            }
        }
    }

    public int pop () {
        int data = -1;
        if (stacks.size() > 0) {
            int stackOnTop = topStack.peek();
            Stack s = stacks.get(stackOnTop);
            data = s.pop();
            if (s.size() == 0) {
                stacks.remove(stackOnTop);
                topStack.pop();
            }
        }
        return data;
    }

    public int popAt (int idx) {
        int data = -1, numStacks = stacks.size();
        if (numStacks > 0 && idx >= 0 && idx < numStacks) {
            Stack s = stacks.get(idx);
            data = s.pop();
            shift(idx+1, numStacks, topStack.peek());
        }
        return data;
    }

    public void shift (int idx, int numStacks, int stackOnTop) {
        if (idx+1 <= numStacks) {
            int bottomOfStack;
            Stack s = stacks.get(idx);
            if (s.size() >= 2)
                bottomOfStack = popBottomOfStack(s);
            else {
                bottomOfStack = s.pop();
                stacks.remove(stackOnTop);
                topStack.pop();
            }
            Stack prevStack = stacks.get(idx - 1);
            prevStack.push(bottomOfStack);
            shift(idx + 1, numStacks, topStack.peek());
        }
    }

    public int popBottomOfStack (Stack stk) {
        Node bottom = stk.top;
        while (bottom.getNext() != null && bottom.getNext().getNext() != null) {
            bottom = bottom.getNext();
        }
        int data = bottom.getNext().getData();
        bottom.setNext(null);
        stk.size--;
        return data;
    }
}
