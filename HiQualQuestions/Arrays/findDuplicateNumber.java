package HiQualQuestions.Arrays;
/* tags

floyds tortoise and hare algorithm
duplicate number in array of n+1 integers
https://leetcode.com/problems/find-the-duplicate-number/solution/

*/ 
public class findDuplicateNumber {
    public int findDuplicate(int[] nums) {
        
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
