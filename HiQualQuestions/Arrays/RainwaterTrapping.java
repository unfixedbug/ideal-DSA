/*Rainwater trapping LC Hard
 * Brute force: O(n^2)
 * 1) left,right array
 * 2) stack
 * 3) two pointer
 */

public class RainwaterTrapping {

  // dynamic programming O(n), O(n) <- space
  public int raiwaterDP(int[] height) {
    //left and right arrays are, largest element in the right, not next greater element

    int n = height.length;
    int left[] = new int[n], right[] = new int[n];
    left[0] = height[0];
    right[n - 1] = height[n - 1];

    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], height[i]);
    }
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], height[i]);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (Integer.min(left[i], right[i]) > height[i]) {
        ans += Integer.min(left[i], right[i]) - height[i];
      }
    }
    return ans;
  }

  // using stack
  public static int maxWater(int[] height) {
    // Stores the indices of the bars
    Stack<Integer> stack = new Stack<>();

    // size of the array
    int n = height.length;

    // Stores the final result
    int ans = 0;

    // Loop through the each bar
    for (int i = 0; i < n; i++) {
      // Remove bars from the stack
      // until the condition holds
      while ((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {
        // store the height of the top
        // and pop it.
        int pop_height = height[stack.peek()];
        stack.pop();

        // If the stack does not have any
        // bars or the popped bar
        // has no left boundary
        if (stack.isEmpty()) break;

        // Get the distance between the
        // left and right boundary of
        // popped bar
        int distance = i - stack.peek() - 1;

        // Calculate the min. height
        int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;

        ans += distance * min_height;
      }

      // If the stack is either empty or
      // height of the current bar is less than
      // or equal to the top bar of stack
      stack.push(i);
    }

    return ans;
  }

  /*optimised two pointer */
  public static int trap(int[] heights) {
    // maintain two pointers left and right, pointing to the leftmost and
    // rightmost index of the input array
    int left = 0, right = heights.length - 1, water = 0;

    int maxLeft = heights[left];
    int maxRight = heights[right];

    while (left < right) {
      if (heights[left] <= heights[right]) {
        left++;
        maxLeft = Integer.max(maxLeft, heights[left]);
        water += (maxLeft - heights[left]);
      } else {
        right--;
        maxRight = Integer.max(maxRight, heights[right]);
        water += (maxRight - heights[right]);
      }
    }

    return water;
  }
}
