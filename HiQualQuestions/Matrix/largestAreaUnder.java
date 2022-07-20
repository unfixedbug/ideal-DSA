import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/max-rectangle/1
/*largest area under histogram */
public class largestAreaUnder {

  public static void main(String[] args) {
    int[][] arr = {
      { 0, 1, 1, 0 },
      { 1, 1, 1, 1 },
      { 1, 1, 1, 1 },
      { 1, 1, 0, 0 },
    };
    int hist[] = { 4, 2, 1, 5, 6, 3, 2, 4, 2 };
    System.out.println(areaunderHistogram(arr));
  }

  //
  private static int areaunderHistogram(int[][] arr) {
    int maxArea = largestArea(arr[0]);
    System.out.println(maxArea);
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 0) {
          continue;
        }
        arr[i][j] += arr[i - 1][j];
      }
      int area = largestArea(arr[i]);
      //   System.out.println(area);
      maxArea = Math.max(maxArea, area);
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    return maxArea;
  }

  private static int largestArea(int a[]) {
    int size = a.length;
    int left[] = new int[size];
    // stores indices of the smallest element
    Stack<Integer> st = new Stack<>();
    left[0] = -1;
    st.push(0);
    for (int i = 1; i < size; i++) {
      while (!st.isEmpty() && a[st.peek()] >= a[i]) {
        st.pop();
      }
      if (st.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = st.peek();
      }
      st.push(i);
    }

    //

    // right smallest element;
    int right[] = new int[size];
    st = new Stack<>();
    right[size - 1] = size;
    st.push(size - 1);
    for (int i = size - 2; i >= 0; i--) {
      while (!st.isEmpty() && a[st.peek()] >= a[i]) {
        st.pop();
      }
      if (st.isEmpty()) {
        right[i] = size;
      } else {
        right[i] = st.peek();
      }
      st.push(i);
    }
    // we have left and right array
    // now we have to find the max area
    int maxArea = 0;
    for (int i = 0; i < size; i++) {
      maxArea = Math.max(maxArea, a[i] * (right[i] - left[i] - 1));
    }
    return maxArea;
  }
}
