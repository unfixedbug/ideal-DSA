//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Solve {

  static int[] findTwoElement(int arr[], int n) {
    // code
    int i = 0;
    while (i < n) {
      int cpos = arr[i] - 1;
      if (arr[i] <= n && arr[i] != arr[cpos]) {
        swap(arr, i, cpos);
      } else i++;
    }
    i = 0;
    while (i < n) {
      if (arr[i] != (i + 1)) {
        return new int[] { arr[i], i + 1 };
      } else i++;
    }
    return new int[] { 0, 0 };
  }

  static void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 5, 3, 4 };
    System.out.println(Arrays.toString(findTwoElement(arr, arr.length)));
  }
}
/* tags
 * repeating and missing element
 * missing and repeating element
 * stable sort
 * cycle sort
 * kunal kushwaha
 * cycle like bs
 */
