package stacksnqueues;

import linkedlist.Node;

/**
 * Created by mayanknarasimhan on 19/12/14.
 *
 * Description:
 * An implementation of the Queue (FIFO) data structure
 */
public class Queue {
    Node head, tail;
    int size;

    public Queue () {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue (int data) {
        Node n = new Node(data);
        if (tail != null) {
            tail.setNext(n);
            tail = n;
        } else {
            tail = n;
            head = tail;
        }
        size++;
    }

    public int dequeue () {
        int data = -1;
        if (head != null) {
            data = head.getData();
            head = head.getNext();
            size--;
        }
        return data;
    }

    public int peek () {
        int data = -1;
        if (head != null) {
            data = head.getData();
        }
        return data;
    }

    public int size () {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }
}
