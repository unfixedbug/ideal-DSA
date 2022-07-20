/* row with maximum number of ones */

// https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
import java.io.*;
import java.util.*;

public class rowWithMaximumNumberOfOnes {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      String[] inputLine;
      inputLine = br.readLine().trim().split(" ");
      int n = Integer.parseInt(inputLine[0]);
      int m = Integer.parseInt(inputLine[1]);
      int[][] arr = new int[n][m];
      inputLine = br.readLine().trim().split(" ");

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
        }
      }
      int ans = new Solution().rowWithMax1s(arr, n, m);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends

//User function Template for Java

class Solution {

  private static int count11(int arr[], int x) {
    int low = 0, high = arr.length - 1;
    int res = -1;
    while (low <= high) {
      int mid = (low + high) >> 1;
      if (arr[mid] > x) {
        high = mid - 1;
      } else if (arr[mid] < x) {
        low = mid + 1;
      }
      // if mid is same as x, then, check to the left also
      else {
        res = mid;
        high = mid - 1;
      }
    }
    if (res == -1) return 0;
    return arr.length - res;
  }

  int rowWithMax1s(int arr[][], int n, int m) {
    // code here
    int count = 0, row = -1;
    for (int i = 0; i < n; i++) {
      int tc = count11(arr[i], 1);
      if (tc > count) {
        count = tc;
        row = i;
      }
    }
    return row;
  }
}
