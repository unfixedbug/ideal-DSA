//problem link -> https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
import java.util.*;

class Solution {

  public long findMinDiff(ArrayList<Integer> a, int n, int m) {
    // your code here
    Collections.sort(a);
    long mins = Long.MAX_VALUE;
    int end = m - 1;
    int start = 0;
    while (end < n) {
      mins = Math.min(a.get(end) - a.get(start), mins);
      // System.out.println(end);
      start++;
      end++;
    }
    return mins;
  }
}
