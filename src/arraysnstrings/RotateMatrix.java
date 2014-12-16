package arraysnstrings;

/**
 * Created by mayanknarasimhan on 15/12/14.
 *
 * Description:
 * Given an image represented by an NxN matrix, where each pixel in the
 * image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */
public class RotateMatrix {
    public static void main (String args[]) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();

        int [][] rotated = rotate90(matrix, 3);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(rotated[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate90(int[][] matrix, int n) {
        for (int row = 0; row < n/2; row++) {
            int first = row, last = (n-1) - row, end = n-1;
            for (int i = first; i < last; i++) {
                // store top
                int top = matrix[row][i];
                // replace top with left
                matrix[row][i] = matrix[end-i][row];
                // replace left with bottom
                matrix[end-i][row] = matrix[end-row][end-i];
                // replace bottom with right
                matrix[end-row][end-i] = matrix[i][end-row];
                // replace right with top
                matrix[i][end-row] = top;
            }
        }
        return matrix;
    }
}
