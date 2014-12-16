package linkedlist;

/**
 * Created by mayanknarasimhan on 16/12/14.
 *
 * Description:
 * A class that serves as the data structure used by linked lists
 */
public class Node {
    Node next;
    int data;

    public Node () {
        this.next = null;
    }

    public Node (int data) {
        this.next = null;
        this.data = data;
    }

    public Node (Node next, int data) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if ((obj == null) || !(obj instanceof Node))
            return false;

        Node n = (Node) obj;
        return n.data == this.data;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
