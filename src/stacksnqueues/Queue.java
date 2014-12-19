package stacksnqueues;

import linkedlist.Node;

/**
 * Created by mayanknarasimhan on 19/12/14.
 *
 * Description:
 * An implementation of the Queue (FIFO) data structure
 */
public class Queue {
    Node first, last;
    int size;

    public Queue () {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue (int data) {
        Node n = new Node(data);
        if (last != null) {
            last.setNext(n);
            last = n;
        } else {
            last = n;
            first = last;
        }
        size++;
    }

    public int dequeue () {
        int data = -1;
        if (first != null) {
            data = first.getData();
            first = first.getNext();
            size--;
        }
        return data;
    }

    public int size () {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }
}
