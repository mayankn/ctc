package stacksnqueues;

import linkedlist.Node;

/**
 * Created by mayanknarasimhan on 21/12/14.
 *
 * Description:
 * Implement a Queue using two stacks.
 */
public class QueueUsingStacks {
    Stack head, tail;
    int size;

    public static void main (String args[]) {
        QueueUsingStacks qus = new QueueUsingStacks();

        qus.enqueue(1);
        qus.enqueue(2);
        qus.enqueue(3);
        qus.enqueue(4);
        qus.enqueue(5);

        System.out.println("qus.dequeue(): " + qus.dequeue());
        System.out.println("qus.dequeue(): " + qus.dequeue());

        qus.enqueue(1);
        qus.enqueue(2);

        System.out.println("qus.dequeue(): " + qus.dequeue());
        System.out.println("qus.dequeue(): " + qus.dequeue());
        System.out.println("qus.dequeue(): " + qus.dequeue());
        System.out.println("qus.dequeue(): " + qus.dequeue());
        System.out.println("qus.dequeue(): " + qus.dequeue());
    }

    public QueueUsingStacks () {
        tail = new Stack();
        head = new Stack();
    }

    public void enqueue (int data) {
        tail.push(data);
        size++;
    }

    public int dequeue () {
        int data = -1;
        if (head.size() > 0) {
            data = head.pop();
            size--;
        } else {
            moveContents(tail, head);
            data = head.pop();
            size--;
        }
        return data;
    }

    public void moveContents (Stack from, Stack to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    public int peek () {
        int data = -1;
        if (!head.isEmpty()) {
            data = head.peek();
        } else {
            moveContents(tail, head);
            data = head.peek();
        }
        return data;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        moveContents(tail, head);
        Node currentNode = head.top;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }
}
