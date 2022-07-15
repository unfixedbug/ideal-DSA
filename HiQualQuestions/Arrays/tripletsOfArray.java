/*
 * 3 sums
 * boolean
 * O(1)space, O(n^2) time
 * Hashmap -> O(n) space, O(n^2) time
 */
public class tripletsOfArray {

  public static void printAllTriplets(int[] nums, int target) {
    Arrays.sort(nums);

    int n = nums.length;

    for (int i = 0; i <= n - 3; i++) {
      // remaining sum
      int k = target - nums[i];

      int low = i + 1;
      int high = nums.length - 1;

      // loop if `low` is less than `high`
      while (low < high) {
        if (nums[low] + nums[high] < k) {
          low++;
        } else if (nums[low] + nums[high] > k) {
          high--;
        }
        // triplet with the given sum is found
        else {
          // print the triplet
          System.out.println(
            "(" + nums[i] + ", " + nums[low] + ", " + nums[high] + ")"
          );

          low++;
          high--;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 2, 7, 4, 0, 9, 5, 1, 3 };
    int target = 6;

    printAllTriplets(nums, target);
  }
}
