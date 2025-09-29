import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int zeroCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        int[][] zeroPositions = new int[zeroCount][2];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroPositions[index][0] = i; // row
                    zeroPositions[index][1] = j; // col
                    index++;
                }
            }
        }
        for (int k = 0; k < zeroCount; k++) {
            int row = zeroPositions[k][0];
            int col = zeroPositions[k][1];
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
