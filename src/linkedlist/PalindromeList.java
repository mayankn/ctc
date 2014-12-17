package linkedlist;

/**
 * Created by mayanknarasimhan on 18/12/14.
 *
 * Description:
 * Implement a function to check if a linked list is a palindrome.
 */
public class PalindromeList {
    public static void main (String args[]) {
        ALinkedList list = new ALinkedList();

        // add elements to LinkedList
        list.addToTail(5);
        list.addToTail(2);
        list.addToTail(7);
        list.addToTail(1);
        list.addToTail(1);
        list.addToTail(7);
        list.addToTail(2);
        list.addToTail(5);

        System.out.println("list: " + list);
        System.out.println("isPalindrome(list): " + isPalindrome(list));
        /*Node head = list.getHead();
        Node tmp = reverseList(head);
        while (tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getNext();
        }*/
    }

    public static boolean isPalindrome (ALinkedList list) {
        Node head = list.getHead();
        if (head == null)
            return false;
        if (list.getSize() < 2)
            return false;

        Node front = head;
        Node reversed = reverseList(head);
        while (front != null) {
            if (front.getData() != reversed.getData())
                return false;
            front = front.getNext();
            reversed = reversed.getNext();
        }
        return true;
    }

    public static Node reverseList (Node currentNode) {
        if (currentNode == null)
            return null;
        if (currentNode.getNext() == null)
            return currentNode;

        Node rest = currentNode.getNext();
        currentNode.setNext(null);
        Node reversed = reverseList(rest);
        rest.setNext(currentNode);
        return reversed;
    }
}
