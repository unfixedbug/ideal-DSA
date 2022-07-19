// contiguous subarray with sum k
/* 560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/ */
import java.util.*;

class Solution {

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(); // sum and its frequency
    map.put(0, 1);
    int sum = 0;
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int remsum = sum - k; // remaining sum
      if (map.containsKey(remsum)) {
        ans += map.get(remsum);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return ans;
  }
}
