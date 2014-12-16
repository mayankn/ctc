package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by mayanknarasimhan on 16/12/14.
 *
 * Description:
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class DuplicateHandler {
    public static void main (String args[]) {
        ALinkedList list = new ALinkedList();
        ALinkedList list1 = new ALinkedList();

        // add elements to LinkedList
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);

        list1.addToTail(1);
        list1.addToTail(2);
        list1.addToTail(3);
        list1.addToTail(2);
        list1.addToTail(3);
        list1.addToTail(4);
        list1.addToTail(5);

        System.out.println("list: " + list);
        System.out.println("removeDuplicates1(list): " + removeDuplicates1(list));
        System.out.println("list: " + list);

        System.out.println("list1: " + list1);
        System.out.println("removeDuplicates2(list1): " + removeDuplicates2(list1));
        System.out.println("list1: " + list1);
    }

    public static ALinkedList removeDuplicates1 (ALinkedList list) {
        Node head = list.getHead();
        if (head == null || list.getSize() < 2)
            return list;

        HashSet<Integer> set = new HashSet<Integer>();
        Node currentNode = head, prev = null;
        while (currentNode != null) {
            if (set.contains(currentNode.getData())) {
                prev.setNext(currentNode.getNext());
            } else {
                set.add(currentNode.getData());
                prev = currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return list;
    }

    public static ALinkedList removeDuplicates2 (ALinkedList list) {
        Node head = list.getHead();
        if (head == null || list.getSize() < 2)
            return list;

        Node currentNode = head, checker = null;
        while (currentNode != null) {
            checker = currentNode;
            while (checker.getNext() != null) {
                if (currentNode.getData() == checker.getNext().getData()) {
                    checker.setNext(checker.getNext().getNext());
                } else {
                    checker = checker.getNext();
                }
            }
            currentNode = currentNode.getNext();
        }
        return list;
    }
}
