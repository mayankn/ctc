package stacksnqueues;

import linkedlist.Node;

/**
 * Created by mayanknarasimhan on 19/12/14.
 *
 * Description:
 * An implementation of the Stack (LIFO) data structure
 */
public class Stack {
    Node top;
    int size;

    public Stack () {
        top = null;
        size = 0;
    }

    public void push (int data) {
        Node n = new Node(data);
        n.setNext(top);
        top = n;
        size++;
    }

    public int pop () {
        int data = -1;
        if (top != null) {
            data = top.getData();
            top = top.getNext();
            size--;
        }
        return data;
    }

    public int peek () {
        int data = -1;
        if (top != null)
            data = top.getData();
        return data;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return top == null;
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
