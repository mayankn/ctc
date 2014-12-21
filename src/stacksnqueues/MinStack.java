package stacksnqueues;

import linkedlist.Node;

/**
 * Created by mayanknarasimhan on 21/12/14.
 *
 * Description:
 * How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element.
 * Push, pop and min should all operate in O(1) time.
 */
public class MinStack {
    Stack minimum;
    Node top;
    int size;

    public static void main (String args[]) {
        MinStack ms = new MinStack();

        ms.push(4);
        ms.push(2);
        ms.push(6);
        ms.push(1);
        ms.push(3);

        System.out.println("ms: " + ms);
        System.out.println("ms.minimum: " + ms.minimum);
        System.out.println("ms.min(): " + ms.min());
        System.out.println("ms.pop(): " + ms.pop());
        System.out.println("ms.min(): " + ms.min());
        System.out.println("ms.pop(): " + ms.pop());
        System.out.println("ms.min(): " + ms.min());
        System.out.println("ms.pop(): " + ms.pop());
        System.out.println("ms.min(): " + ms.min());
        System.out.println("ms: " + ms);
    }

    public MinStack () {
        minimum = new Stack();
    }

    public void push (int data) {
        Node n = new Node(data);
        n.setNext(top);
        top = n;
        if (minimum.peek() != -1) {
            int prevMin = minimum.peek();
            if (data <= prevMin)
                minimum.push(data);
            else
                minimum.push(prevMin);
        } else {
            minimum.push(data);
        }

        size++;
    }

    public int pop () {
        int data = -1;
        if (top != null) {
            data = top.getData();
            top = top.getNext();
            minimum.pop();
            size--;
        }
        return data;
    }

    public int min () {
        return minimum.peek();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = top;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }
}
