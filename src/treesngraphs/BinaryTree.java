package treesngraphs;

/**
 * Created by mayanknarasimhan on 23/12/14.
 *
 * Description:
 * Am implementation of a binary tree data structure
 */
public class BinaryTree {
    int data;
    BinaryTree left, right, parent;

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

    public static void setParents (BinaryTree root) {
        root.parent = setParentsHelper(root);
    }

    public static BinaryTree setParentsHelper (BinaryTree tree) {
        if (tree == null)
            return null;

        if (tree.left != null) {
            tree.left.parent = tree;
            setParentsHelper(tree.left);
        }
        if (tree.right != null) {
            tree.right.parent = tree;
            setParentsHelper(tree.right);
        }
        return null;
    }
}
