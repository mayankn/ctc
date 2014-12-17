package linkedlist;

/**
 * Created by mayanknarasimhan on 17/12/14.
 *
 * Description:
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1s digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 */
public class Addition {
    public static void main (String args[]) {
        Addition addition = new Addition();
        ALinkedList list1 = new ALinkedList();
        ALinkedList list2 = new ALinkedList();

        // add elements to LinkedList
        list1.addToTail(6);
        list1.addToTail(2);
        list1.addToTail(7);

        list2.addToTail(4);
        list2.addToTail(8);
        list2.addToTail(6);

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("add(list1, list2): " + addition.add1(list1, list2));
        System.out.println("add1Recursive(list1, list2): " + addition.add1Recursive(list1, list2));
        System.out.println("add2Recursive(list1, list2): " + addition.add2Recursive(list1, list2));
    }

    public ALinkedList add1 (ALinkedList list1, ALinkedList list2) {
        Node head1 = list1.getHead();
        Node head2 = list2.getHead();

        if (head2 == null)
            return list1;
        if (head1 == null)
            return list2;

        Node longer = null, shorter = null;
        if (list1.getSize() >= list2.getSize()) {
            longer = head1;
            shorter = head2;
        } else {
            longer = head2;
            shorter = head1;
        }
        ALinkedList newList = new ALinkedList();
        int carryOver = 0, sum = 0, down = 0;
        while (longer != null) {
            if (shorter != null) {
                sum = longer.getData() + shorter.getData() + carryOver;
                down = sum % 10;
                carryOver = sum / 10;
                shorter = shorter.getNext();
            } else {
                sum = longer.getData() + carryOver;
                down = sum % 10;
                carryOver = sum / 10;
            }
            newList.addToTail(down);
            longer = longer.getNext();
        }
        if (carryOver > 0)
            newList.addToTail(carryOver);
        return newList;
    }

    public ALinkedList add1Recursive (ALinkedList list1, ALinkedList list2) {
        Node head1 = list1.getHead();
        Node head2 = list2.getHead();

        if (head2 == null)
            return list1;
        if (head1 == null)
            return list2;

        Node longer = null, shorter = null;
        if (list1.getSize() >= list2.getSize()) {
            longer = head1;
            shorter = head2;
        } else {
            longer = head2;
            shorter = head1;
        }
        ALinkedList newList = add1RecursiveHelper(longer, shorter, null, 0);
        return newList;
    }

    public ALinkedList add1RecursiveHelper (Node longer, Node shorter, ALinkedList newList, int carryOver) {
        if (longer == null) {
            if (carryOver > 0)
                newList.addToTail(carryOver);
            return newList;
        }

        if (shorter != null) {
            int sum = longer.getData() + shorter.getData() + carryOver;
            int down = sum % 10;
            carryOver = sum / 10;
            if (newList == null)
                newList = new ALinkedList();
            newList.addToTail(down);
            return add1RecursiveHelper(longer.getNext(), shorter.getNext(), newList, carryOver);
        } else {
            int sum = longer.getData() + carryOver;
            int down = sum % 10;
            carryOver = sum / 10;
            if (newList == null)
                newList = new ALinkedList();
            newList.addToTail(down);
            return add1RecursiveHelper(longer.getNext(), null, newList, carryOver);
        }
    }

    public ALinkedList add2Recursive (ALinkedList list1, ALinkedList list2) {
        Node head1 = list1.getHead();
        Node head2 = list2.getHead();

        if (head2 == null)
            return list1;
        if (head1 == null)
            return list2;

        Node longer = null, shorter = null;
        int delta = list1.getSize() - list2.getSize();
        if (list1.getSize() >= list2.getSize()) {
            while (delta > 0) {
                list2.addtoHead(0);
                delta--;
            }
        } else {
            while (delta > 0) {
                list1.addtoHead(0);
                delta--;
            }
        }
        CarryOver carryOver = new CarryOver();
        ALinkedList newList = add2RecursiveHelper(list1.getHead(), list2.getHead(), carryOver);
        if (carryOver.value > 0)
            newList.addtoHead(carryOver.value);
        return newList;
    }

    public ALinkedList add2RecursiveHelper (Node n1, Node n2, CarryOver carryOver) {
        ALinkedList tmp = null;
        if(n1.getNext() != null && n2.getNext() != null) {
            tmp = add2RecursiveHelper(n1.getNext(), n2.getNext(), carryOver);
        }

        int sum = n1.getData() + n2.getData() + carryOver.value;
        int down = sum % 10;
        carryOver.value = sum / 10;
        if (tmp == null)
            tmp = new ALinkedList();
        tmp.addtoHead(down);
        return tmp;
    }

    private class CarryOver {
        int value = 0;
    }
}
