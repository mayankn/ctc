package treesngraphs;

/**
 * Created by mayanknarasimhan on 23/12/14.
 *
 * Description:
 * Am implementation of a binary tree data structure
 */
public class BinaryTree {
    int data;
    BinaryTree left, right;

    public BinaryTree () {
        left = null;
        right = null;
    }

    public BinaryTree (int _data) {
        data = _data;
        left = null;
        right = null;
    }

    public BinaryTree (int _data, BinaryTree _left, BinaryTree _right) {
        data = _data;
        left = _left;
        right = _right;
    }

    public static void printPreOrder (BinaryTree root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
