import java.util.*;

public class SpiralTraversal {

  public static void main(String[] args) {
    int r = 3, c = 5;
    int matrix[][] = {
      { 6, 6, 2, 28, 2 },
      { 12, 26, 3, 28, 7 },
      { 22, 25, 3, 4, 13 },
    };
    System.out.println(spirallyTraverse(matrix, r, c));
  }

  static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
    // code here
    ArrayList<Integer> ans = new ArrayList<>();
    int minrow = 0, mincol = 0;
    int maxrow = r - 1, maxcol = c - 1;

    while (mincol <= maxcol && minrow <= maxrow) {
      for (int i = mincol; i <= maxcol; i++) {
        ans.add(matrix[minrow][i]);
      }
      minrow++;

      for (int i = minrow; i <= maxrow; i++) {
        ans.add(matrix[i][maxcol]);
      }
      maxcol--;

      if (minrow <= maxrow) {
        for (int i = maxcol; i >= mincol; i--) {
          ans.add(matrix[maxrow][i]);
        }
        maxrow--;
      }

      if (mincol <= maxcol) {
        for (int i = maxrow; i >= minrow; i--) {
          ans.add(matrix[i][mincol]);
        }
        mincol++;
      }
    }
    return ans;
  }
}
