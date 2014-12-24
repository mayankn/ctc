package treesngraphs;

/**
 * Created by mayanknarasimhan on 24/12/14.
 *
 * Description:
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 */
public class GetNext {
    public static void main (String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        SortedArrayBST s = new SortedArrayBST();
        BinaryTree root = s.createBST(arr);
        BinaryTree.setParents(root);
        System.out.println(inOrderSuccessor(root.left.right.right).data);
    }

    public static BinaryTree inOrderSuccessor (BinaryTree root) {
        if (root == null)
            return null;

        if (root.right != null) {
            return getLeftMostNode(root.right);
        }
        while (root.parent != null && root.parent.right.equals(root)) {
            root = root.parent;
        }
        return root.parent;
    }

    public static BinaryTree getLeftMostNode (BinaryTree tree) {
        if (tree == null)
            return null;

        if (tree.left == null)
            return tree;
        return getLeftMostNode(tree.left);
    }
}
