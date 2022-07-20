public class bt {

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

  private static int rowWithMax1s(int arr[][], int n, int m) {
    // code here
    int count = 0, row = 0;
    for (int i = 0; i < n; i++) {
      int tc = count11(arr[i], 1);
      System.out.println("row:" + i + ", count:" + tc);
      if (tc > count) {
        count = tc;
        row = i+1;
      }
    }
    return row;
  }

  public static void main(String[] args) {
    int arr[][] = {
      { 0, 1, 1, 1 },
      { 0, 0, 1, 1 },
      { 1, 1, 1, 1 },
      { 0, 0, 0, 0 },
    };
    System.out.println(rowWithMax1s(arr, 4, 4));
  }
}
