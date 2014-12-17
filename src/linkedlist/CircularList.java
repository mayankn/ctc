package linkedlist;

import java.util.HashSet;

/**
 * Created by mayanknarasimhan on 17/12/14.
 *
 * Description:
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer
 * points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input:A->B->C->D->E->C [the same C as earlier]
 * Output:C
 */
public class CircularList {
    public static void main (String args[]) {
        ALinkedList list = new ALinkedList();

        // add elements to LinkedList
        Node loop = new Node(2);
        list.addToTail(5);
        list.getTail().setNext(loop);
        list.addToTail(7);
        list.addToTail(4);
        list.getTail().setNext(loop);

        //System.out.println("list: " + list);
        System.out.println("loopNode2(list): " + loopNode2(list).getData());

    }

    public static Node loopNode1 (ALinkedList list) {
        Node head = list.getHead();
        if (head == null)
            return null;
        if (list.getSize() < 3)
            return null;

        HashSet<Integer> set = new HashSet<Integer>();
        Node currentNode = head;
        while (currentNode != null) {
            if (set.contains(currentNode.getData())) {
                return currentNode;
            }
            set.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public static Node loopNode2 (ALinkedList list) {
        Node head = list.getHead();
        if (head == null)
            return null;
        if (list.getSize() < 3)
            return null;

        Node currentNode = head, runner = head;
        while (runner != null && runner.getNext() != null) {
            currentNode = currentNode.getNext();
            runner = runner.getNext().getNext();
            if (currentNode == runner)
                break;
        }
        if (runner == null && runner.getNext() == null)
            return null;
        currentNode = head;
        while (currentNode != runner) {
            currentNode = currentNode.getNext();
            runner = runner.getNext();
        }
        return currentNode;
    }
}
