public class SearchInA2Dmatrix {

  // rowwise and columnwise sorted matrix
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0, j = matrix[0].length - 1;

    /*
            eberything to the left of j, is smaller than j, and everything to the bottom of j is larger than j, 
            
            
            if target < j, then j--
            if target >j , then row++
            */

    while (row < matrix.length && j >= 0) {
      if (matrix[row][j] == target) return true; else if (
        matrix[row][j] > target
      ) j--; else if (matrix[row][j] < target) row++; // target lies in same row, lesser column
    }
    return false;
  }
}
