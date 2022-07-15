package HiQualQuestions.Arrays;

/* tags
minimum number of jumps to reach end
dp
1d dp
jump game
*/

class jumpGame1 {

  public static void main(String[] args) {}

  private int jump(int nums[]) {
    int currFar = 0, jumps = 0, curend = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      currFar = Math.max(currFar, i + nums[i]);
      if (i == curend) {
        jumps++;
        curend = currFar;
        if (curend >= nums.length - 1) return jumps;
      }
    }
    return -1;
  }
}
