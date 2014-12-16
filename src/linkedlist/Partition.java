package linkedlist;

/**
 * Created by mayanknarasimhan on 16/12/14.
 *
 * Description:
 * Write code to partition a linked list around a value x, such that,
 * all nodes less than x come before all nodes greater than or equal to x.
 */
public class Partition {
    public static void main (String args[]) {
        ALinkedList list = new ALinkedList();

        // add elements to LinkedList
        list.addToTail(5);
        list.addToTail(2);
        list.addToTail(7);
        list.addToTail(4);
        list.addToTail(1);
        list.addToTail(6);
        list.addToTail(3);

        System.out.println("list: " + list);
        System.out.println("partitionList(list, 4): " + partitionList(list, 4));
    }

    public static ALinkedList partitionList (ALinkedList list, int pivot) {
        Node head = list.getHead();
        if (head == null || head.getNext() == null)
            return list;

        ALinkedList lesser = new ALinkedList(), greater = new ALinkedList();
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() >= pivot)
                greater.addtoHead(currentNode.getData());
            else
                lesser.addtoHead(currentNode.getData());

            currentNode = currentNode.getNext();
        }
        if (lesser.getHead() == null)
            return greater;
        lesser.getTail().setNext(greater.getHead());
        return lesser;
    }
}
