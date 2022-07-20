/*median of rowwise sorted matrix
 * https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/
 * https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
 */
public class medianOfRowWisesortedMatrix {

  // returns number of elements in array A, smaller than mid
  // 1 2 3 5 6 8 ,(mid:4)-> 3
  public static int countSmallerThanmid(int a[], int target, int n) {
    int l = 0, h = n - 1;
    while (l <= h) {
      int mid = (l + h) >> 1;
      if (a[mid] <= target) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return l;
  }

  public static int findMedian(int a[][], int row, int col) {
    int low = 0, high = 1000000000;
    int total = row * col; // total number of elements in matrix

    while (low <= high) {
      int mid = (low + high) >> 1;

      int count = 0;
      // this loop, gets number of elements in all matrix smaller than mid
      for (int i = 0; i < row; i++) {
        count += countSmallerThanmid(a[i], mid, col);
      }
      if (count <= (total) / 2) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static void main(String args[]) {
    int row = 3, col = 3;
    int[][] arr = { { 1, 3, 8 }, { 2, 3, 4 }, { 1, 2, 5 } };
    System.out.println(
      // "The median of the row-wise sorted matrix is: " +
      // findMedian(arr, row, col)
    );

    int temp[] = {1,2,4,5,7,8,9};
    System.out.println(countSmallerThanmid(temp, 5, temp.length));
  }
}
