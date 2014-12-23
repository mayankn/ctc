package treesngraphs;

/**
 * Created by mayanknarasimhan on 22/12/14.
 *
 * Description:
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 */
public class BalancedBinaryTree {
    BinaryTree root;

    public static void main (String args[]) {
        BinaryTree left = new BinaryTree(2, new BinaryTree(4), new BinaryTree(5));
        BinaryTree right = new BinaryTree(3, new BinaryTree(6), new BinaryTree(7));
        BalancedBinaryTree bbt = new BalancedBinaryTree(new BinaryTree(1, left, right));
        System.out.println(bbt.isBalanced(bbt.root));
    }

    public BalancedBinaryTree () {
        root = null;
    }

    public BalancedBinaryTree (BinaryTree tree) {
        root = tree;
    }

    public boolean isBalanced (BinaryTree root) {
        if (height(root) == -1)
            return false;
        else
            return true;
    }

    public int height (BinaryTree tree) {
        if (tree == null)
            return 0;
        int leftHeight = height(tree.left);
        if (leftHeight < 0)
            return -1;
        int rightHeight = height(tree.right);
        if (rightHeight < 0)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(height(tree.left), height(tree.right)) + 1;
    }
}
