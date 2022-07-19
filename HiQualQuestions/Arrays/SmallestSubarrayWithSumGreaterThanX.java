//problem link
// https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1

class SmallestSubarrayWithSumGreaterThanX {

  public static int smallestSubWithSum(int a[], int n, int x) {
    // Your code goes here
    int l = 0, h = 0;
    int sum = 0;
    // if(sum>x)return 1;
    int mins = Integer.MAX_VALUE;
    while (h < n) {
      while (sum <= x && h < n) {
        sum += a[h++];
      }
      while (sum > x && l < n) {
        if (h - l < mins) {
          mins = h - l;
        }
        sum -= a[l++];
      }
    }
    return mins;
  }
}
