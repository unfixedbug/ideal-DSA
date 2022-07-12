// tags:
//  partition to k equal subsets
// subset sum problem
// subset sum variation
// k subset with equal sum
// matchstick problem

/*credits
 * https://www.youtube.com/watch?v=mBk4I0X46oI -> neetcode
 *
 * https://www.youtube.com/watch?v=rszwy53vaP0 -> pepcoding, sumeet bhaiiya
 
 references :
 https://www.techiedelight.com/k-partition-problem-print-all-subsets/
 https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/
 */

package HiQualQuestions.BackTracking;

public class partitionToKEqualSubsets {

  static boolean isKSubsetsPossible(int[] arr, int k) {
    // if we have to draw one subset, return true
    int arlen = arr.length;
    if (k == 1) return true;

    // if number of elements is less than the subsets we need to make, return false
    if (arlen < k) return false;

    long sum = IntStream.of(arr).sum(); // get sum of all elements

    if (sum & k != 0) return false;
  }

  public static void main(String[] args) {
    // Input: a set of integers
    int[] S = { 7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4 };
    int k = 5;

    System.out.println(isKSubsetsPossible(S, k)); // going to return boolean);
  }
}
// print subsets, with equal sum , k subsets
