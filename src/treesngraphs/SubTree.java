package treesngraphs;

/**
 * Created by mayanknarasimhan on 25/12/14.
 *
 * Description:
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.

 */
public class SubTree {
    public static boolean isSubTree (BinaryTree t1, BinaryTree t2) {
        if (t2 == null)
            return true;
        return isPresent(t1, t2);
    }

    public static boolean isPresent (BinaryTree t1, BinaryTree t2) {
        if (t1 == null)
            return false;
        if (t1.equals(t2)) {
            if (isMatch(t1, t2))
                return true;
        }
        return isPresent(t1.left, t2) || isPresent(t1.right, t2);
    }

    public static boolean isMatch (BinaryTree t1, BinaryTree t2) {
        if (t1 == null && t2 == null)
            return true;
        if (!t1.equals(t2))
            return false;
        return isMatch(t1.left, t2.left) && isMatch(t1.right, t2.right);
    }
}
