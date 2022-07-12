package HiQualQuestions.Arrays;

/*
 * Sort array of 0,1,2
 * 1) Counting Sort
 * 2) Dutch National Flag Algorithm [low, mid, high]
 */
public class DutchNationalFlag {

  /*
   * if mid==0 then swap mid , low  [low++, mid++];
   * if mid==2 then swap mid high, high--
   * if mid==1 then mid++
   * Such that [0,low,mid,high] -> 0,low  contains 0's
   *                            low, high contains 1's
   *                           high,n-1 contains 2's
   */
   */

  public static void sort(int[] arr) {
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;

    while (mid <= high) {
      if (arr[mid] == 0) {
        swap(arr, low, mid);
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        swap(arr, mid, high);
        high--;
      }
    }
  }
}
