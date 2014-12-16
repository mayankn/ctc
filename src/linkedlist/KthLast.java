package linkedlist;

/**
 * Created by mayanknarasimhan on 16/12/14.
 *
 * Description:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthLast {
    public static void main (String args[]) {
        ALinkedList list = new ALinkedList();
        KthLast k = new KthLast();

        // add elements to LinkedList
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);
        list.addToTail(7);

        System.out.println("list: " + list);
        System.out.println("kthToLast(list, 3): " + k.kthToLast(list, 3));
        System.out.println("kthToLastRecursive(list, 3): " + k.kthToLastRecursive(list, 3));
    }

    public int kthToLast (ALinkedList list, int k) {
        if (list.getSize() < k) {
            return -1;
        }
        Node head = list.getHead();
        if (list.getSize() == k) {
            return head.getData();
        }

        int runnerIdx = k;
        Node currentNode = head, runner = head;
        while (runner.getNext() != null && runnerIdx > 1) {
            runner = runner.getNext();
            runnerIdx--;
        }
        while (runner.getNext() != null) {
            currentNode = currentNode.getNext();
            runner = runner.getNext();
        }
        return currentNode.getData();
    }

    public int kthToLastRecursive (ALinkedList list, int k) {
        if (list.getHead() == null)
            return -1;
        Node n = kthToLastRecursiveHelper (list.getHead(), k, new IntWrapper());
        return n.getData();
    }

    public Node kthToLastRecursiveHelper (Node currentNode, int k, IntWrapper iw) {
        if (currentNode == null) {
            return null;
        }
        Node n = kthToLastRecursiveHelper(currentNode.getNext(), k, iw);
        iw.counter += 1;
        if (iw.counter == k)
            return currentNode;
        return n;
    }

    private class IntWrapper {
        int counter = 0;
    }
}
