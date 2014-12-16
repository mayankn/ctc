package linkedlist;

/**
 * Created by mayanknarasimhan on 16/12/14.
 *
 * Description:
 * An implementation of a linked list from scratch using the Node class
 */
public class ALinkedList {
    Node head;
    int size;

    public ALinkedList () {
        this.head = null;
        this.size = 0;
    }

    public static void main (String args[]) {
        ALinkedList list = new ALinkedList();

        // add elements to LinkedList
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);

        System.out.println("list: " + list);
        System.out.println("list.getSize(): " + list.getSize());
        System.out.println("list.get(3): " + list.get(3).getData());
        System.out.println("list.remove(3): " + list.remove(3));
        System.out.println("list.getSize(): " + list.getSize());
        System.out.println("list.get(3): " + list.get(3).getData());
        System.out.println("list: " + list);
        System.out.println("list.remove(1): " + list.remove(1));
        System.out.println("list.getSize(): " + list.getSize());
        System.out.println("list.get(3): " + list.get(3).getData());
        System.out.println("list: " + list);
    }

    public void addToTail (int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node tail = getTail();
            tail.setNext(n);
       }
        size++;
    }

    public void addtoHead (int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            n.setNext(head);
        }
        size++;
    }

    public void addAfter (Node after, int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null && !currentNode.equals(after)) {
                currentNode = currentNode.getNext();
            }
            n.setNext(currentNode.getNext());
            currentNode.setNext(n);
        }
        size++;
    }

    public void addAtIndex (int data, int idx) {
        Node n = new Node(data);
        Node currentNode = head;
        for (int i = 1; currentNode.getNext() != null && i < idx; i++) {
            currentNode = currentNode.getNext();
        }
        n.setNext(currentNode.getNext());
        currentNode.setNext(n);
        size++;
    }

    public Node get (int idx) {
        Node currentNode = head;
        for (int i = 1; i < idx; i++) {
            if (currentNode.getNext() == null)
                return null;
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public boolean remove (Node n) {
        if (head == null)
            return false;
        Node currentNode = head;
        while (currentNode.getNext() != null && !currentNode.getNext().equals(n)) {
            if (currentNode.getNext() == null)
                return false;
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        size--;
        return true;
    }

    public boolean remove (int idx) {
        if (head == null)
            return false;
        if (idx < 1 || idx > getSize())
            return false;
        if (idx == 1) {
            head = head.getNext();
            size--;
            return true;
        }
        Node currentNode = head;
        for (int i = 1; i < idx-1; i++) {
            if (currentNode.getNext() == null)
                return false;
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        size--;
        return true;
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public Node getTail() {
        if (head == null) {
            return null;
        }
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        while (currentNode != null) {
            sb.append("[ ");
            sb.append(currentNode.getData());
            sb.append(" ]");
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }
}
