package treesngraphs;

/**
 * Created by mayanknarasimhan on 25/12/14.
 *
 * Description:
 * You are given a binary tree in which each node contains a value.
 * Design an algorithm to print all paths which sum to a given value.
 * The path does not need to start or end at the root or a leaf.
 */
public class AllPathsSum {
    public static void main (String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        SortedArrayBST s = new SortedArrayBST();
        BinaryTree root = s.createBST(arr);
        int[] path = new int[arr.length];
        printAllPaths(root, 9, path, 0);
    }

    public static void printAllPaths (BinaryTree tree, int sum, int[] path, int level) {
        if (tree == null)
            return;
        path[level] = tree.data;
        pathSum(path, sum, level);
        printAllPaths(tree.left, sum, path, level+1);
        printAllPaths(tree.right, sum, path, level+1);
        path[level] = Integer.MIN_VALUE;
    }

    public static void pathSum (int[] path, int sum, int end) {
        int sumSoFar = 0;
        for (int i = end; i >= 0; i--) {
            sumSoFar += path[i];
            if (sumSoFar == sum) {
                printPath(path, end, i);
            }
        }
    }

    public static void printPath (int[] path, int startIdx, int endIdx) {
        for (int i = startIdx; i >= endIdx; i--) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
}
