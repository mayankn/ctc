package treesngraphs;

/**
 * Created by mayanknarasimhan on 24/12/14.
 *
 * Description:
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class CheckBST {
    public static void main (String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        SortedArrayBST s = new SortedArrayBST();
        BinaryTree left = new BinaryTree(2, new BinaryTree(4), new BinaryTree(5));
        BinaryTree right = new BinaryTree(3, new BinaryTree(6), new BinaryTree(7));
        BalancedBinaryTree bbt = new BalancedBinaryTree(new BinaryTree(1, left, right));
        System.out.println(isBST(s.createBST(arr)));
        System.out.println(isBST(bbt.root));
    }

    public static boolean isBST (BinaryTree root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTHelper (BinaryTree tree, int min, int max) {
        if (tree == null)
            return true;

        if (min > tree.data || max <= tree.data)
            return false;

        return isBSTHelper(tree.left, min, tree.data) && isBSTHelper(tree.right, tree.data, max);
    }
}
