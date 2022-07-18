import java.util.HashMap;

public class countPairsWithGivenSum {

  private static int getPairsCount(int arr[], int k) {
    int count = 0;
    int n = arr.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(k - arr[i])) {
        count += map.get(k - arr[i]);
      }
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    int sum = 6;
    int arr[] = new int[] { 1, 5, 7, -1, 5 };
    System.out.println("Count of pairs is " + getPairsCount(arr, sum));
  }
}
