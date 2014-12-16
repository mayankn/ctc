package linkedlist;

/**
 * Created by mayanknarasimhan on 16/12/14.
 *
 * Description:
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: the new linked list looks like a->b->d->e
 */
public class DeleteMiddle {
    public static void main (String args[]) {
        ALinkedList list = new ALinkedList();

        // add elements to LinkedList
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);
        list.addToTail(7);

        Node toDelete = list.get(4);

        System.out.println("list: " + list);
        System.out.println("deleteNodeFromMiddle(toDelete): " + deleteNodeFromMiddle(toDelete));
        System.out.println("list: " + list);
    }

    public static boolean deleteNodeFromMiddle (Node n) {
        if (n == null || n.getNext() == null)
            return false;
        n.setData(n.getNext().getData());
        n.setNext(n.getNext().getNext());
        return true;
    }
}
