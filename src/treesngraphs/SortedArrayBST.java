package treesngraphs;

/**
 * Created by mayanknarasimhan on 23/12/14.
 *
 * Description:
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class SortedArrayBST {
    public static void main (String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        SortedArrayBST s = new SortedArrayBST();
        BinaryTree.printPreOrder(s.createBST(arr));
    }

    public BinaryTree createBST (int[] arr) {
        return createBSTHelper(arr, 0, arr.length - 1);
    }

    public BinaryTree createBSTHelper (int[] arr, int start, int end) {
        if (end < start)
            return null;

        int mid = (start + end) / 2;
        BinaryTree tree = new BinaryTree(arr[mid]);
        tree.left = createBSTHelper(arr, start, mid - 1);
        tree.right = createBSTHelper(arr, mid + 1, end);
        return tree;
    }
}
