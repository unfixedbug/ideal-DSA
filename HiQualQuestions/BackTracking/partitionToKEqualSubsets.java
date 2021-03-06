package HiQualQuestions.BackTracking;

import java.util.Arrays;
import java.util.stream.IntStream;

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

public class partitionToKEqualSubsets {

  static boolean kSubsets(
    int[] arr,
    int k,
    int arlen,
    int subsetSum[],
    boolean[] taken,
    int subset,
    int curIdx,
    int limitIdx
  ) {
    // subset is completed
    if (subsetSum[curIdx] == subset) { // if we reached the desired value
      int lastIndex = k - 1;
      // if we reached the last-1th index, we can automatically devise the last subset
      if (curIdx == lastIndex - 1) return true;
      //else ,if not last index, recur for next index
      return kSubsets(
        arr,
        k,
        arlen,
        subsetSum,
        taken,
        subset,
        curIdx + 1,
        arlen - 1
      );
    }
    // else if this subset is not completed
    for (int i = limitIdx; i >= 0; i--) {
      if (taken[i]) continue; // if this index is already taken, skip it

      int currSum = subsetSum[curIdx] + arr[i];

      // if currsum is less than that of required value, then only take it
      if (currSum <= subset) {
        taken[i] = true;
        subsetSum[curIdx] = currSum;
        // recur for the same index
        boolean thisSubset = kSubsets(
          arr,
          k,
          arlen,
          subsetSum,
          taken,
          subset,
          curIdx,
          i - 1
        );

        // backtrack boys
        taken[i] = false;
        subsetSum[curIdx] -= arr[i];

        if (thisSubset) return true;
      }
    }
    return false;
  }

  static boolean isKSubsetsPossible(int[] arr, int k) {
    // if we have to draw one subset, return true
    int arlen = arr.length;
    if (k == 1) return true;

    // if number of elements is less than the subsets we need to make, return false
    if (arlen < k) return false;

    int sum = IntStream.of(arr).sum(); // get sum of all elements

    if (sum % k != 0) return false;

    int subset = sum / k; // sum of each subset
    int subsetsum[] = new int[k]; // array to store sum of each subset
    boolean[] taken = new boolean[arlen]; // array to store if element is taken or not

    Arrays.fill(subsetsum, 0);
    Arrays.fill(taken, false);

    // take first subset as last element of array and mark that as taken
    subsetsum[0] = arr[arlen - 1];
    taken[arlen - 1] = true;

    // subset array starts from 0,
    // and we start from last element of array,
    return kSubsets(arr, k, arlen, subsetsum, taken, subset, 0, arlen - 1);
  }

  public static void main(String[] args) {
    // Input: a set of integers
    int[] S = { 4, 3, 2, 3, 5, 2, 1 };
    int k = 4;

    System.out.println(isKSubsetsPossible(S, k)); // going to return boolean);
  }
}
// print subsets, with equal sum , k subsets
