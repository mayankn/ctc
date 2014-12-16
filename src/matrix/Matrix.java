package matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by mayanknarasimhan on 16/12/14.
 *
 * Description:
 * Write an algorithm such that if an element in an MxN matrix is 0,its
 * entire row and column are set to 0.
 */
public class Matrix {
    public static void main (String args[]) {
        int[][] matrix = {{1,2,3}, {4,0,6}, {7,8,9}};

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();

        int [][] newMatrix = setMatrix(matrix);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(newMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] setMatrix (int[][] matrix) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        int m = matrix.length, n = matrix[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    set.add(list);
                }
            }
        }

        Iterator<ArrayList<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            ArrayList<Integer> list = iterator.next();
            int row = list.get(0), column = list.get(1);
            for (int i=0; i<m; i++) {
                matrix[row][i] = 0;
            }
            for (int j=0; j<n; j++) {
                matrix[j][column] = 0;
            }
        }
        return matrix;
    }
}
