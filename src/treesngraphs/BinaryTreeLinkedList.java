package treesngraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mayanknarasimhan on 24/12/14.
 *
 * Description:
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D,you'll have D linked lists).
 */
public class BinaryTreeLinkedList {
    public static void main (String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        SortedArrayBST s = new SortedArrayBST();
        for (LinkedList<Integer> l : createLists(s.createBST(arr))) {
            for (Integer i : l) {
                System.out.print(i.intValue() + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<LinkedList<Integer>> createLists (BinaryTree root) {
        if (root == null)
            return null;

        ArrayList<LinkedList<Integer>> listOfLists = new ArrayList<LinkedList<Integer>>();
        Queue<BinaryTree> q = new ArrayDeque<BinaryTree>();
        // delimiter node to mark the end of a level (not entirely necessary)
        BinaryTree delimiterNode = new BinaryTree(-1);
        LinkedList<Integer> list = new LinkedList<Integer>();
        q.add(root);
        q.add(delimiterNode);
        BinaryTree treeNode = null;
        while (!q.isEmpty()) {
            treeNode = q.remove();
            if (treeNode.equals(delimiterNode)) {
                listOfLists.add(list);
                if (q.size() != 0)
                    q.add(delimiterNode);
                list = new LinkedList<Integer>();
            } else {
                list.add(treeNode.data);
                if (treeNode.left != null)
                    q.add(treeNode.left);
                if (treeNode.right != null)
                    q.add(treeNode.right);
            }
        }
        return listOfLists;
    }
}
