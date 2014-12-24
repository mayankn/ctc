package treesngraphs;

/**
 * Created by mayanknarasimhan on 24/12/14.
 *
 * Description:
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 */
public class CommonAncestor {
    public static void main (String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        SortedArrayBST s = new SortedArrayBST();
        BinaryTree root = s.createBST(arr);
        System.out.println(getFirstCommonAncestor(root, root.left.left, root.left.right.right).data);
        System.out.println(getFirstCommonAncestor1(root, root.left.left, root.left.right.right).data);
    }

    public static BinaryTree getFirstCommonAncestor (BinaryTree root, BinaryTree n1, BinaryTree n2) {
        if (root == null)
            return null;
        if (root.equals(n1) || root.equals(n2))
            return root;

        if (isNodePresent(root.left, n1) && isNodePresent(root.right, n2))
            return root;
        if (isNodePresent(root.left, n1) && isNodePresent(root.left, n2)) {
             return getFirstCommonAncestor(root.left, n1, n2);
        }
        if (isNodePresent(root.right, n1) && isNodePresent(root.right, n2)) {
            return getFirstCommonAncestor(root.right, n1, n2);
        }
        return null;
    }

    public static boolean isNodePresent (BinaryTree subTree, BinaryTree n) {
        if (subTree == null)
            return false;

        if (subTree.equals(n))
            return true;

        return isNodePresent(subTree.left, n) || isNodePresent(subTree.right, n);
    }

    public static BinaryTree getFirstCommonAncestor1 (BinaryTree root, BinaryTree n1, BinaryTree n2) {
        if (root == null)
            return null;
        if (root.equals(n1) || root.equals(n2))
            return root;

        BinaryTree left = getFirstCommonAncestor1(root.left, n1, n2);
        BinaryTree right = getFirstCommonAncestor1(root.right, n1, n2);
        if (left == null && right == null)
            return null;
        if (left != null && right != null && !left.equals(right))
            return root;
        if (left != null && right == null)
            return left;
        if (left == null && right != null)
            return right;
        return null;
    }
}
