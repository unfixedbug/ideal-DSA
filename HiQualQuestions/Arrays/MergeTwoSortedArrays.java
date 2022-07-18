/* merge two sorted arrays
 * merge k sorted arrays
 * merge without using extra spaces
 */
public class MergeTwoSortedArrays { // time -> O(n*m) , space -> O(1)

  static void merge(int[] arr1, int arr2[]) {
    int n = arr2.length;
    int m = arr1.length;
    // Iterate through all elements of ar2[] starting from
    // the last element
    for (int i = n - 1; i >= 0; i--) {
      /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
      int j, last = arr1[m - 1];
      for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--) arr1[j + 1] = arr1[j];

      // If there was a greater element
      if (j != m - 2 || last > arr2[i]) {
        arr1[j + 1] = arr2[i];
        arr2[i] = last;
      }
    }
  }

  // Driver method to test the above function
  public static void main(String[] args) {
    int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
    int arr2[] = new int[] { 2, 3, 8, 13 };

    merge(arr1, arr2);
    System.out.print("After Merging nFirst Array: ");
    System.out.println(Arrays.toString(arr1));
    System.out.print("Second Array:  ");
    System.out.println(Arrays.toString(arr2));
  }

  //   time -> O((m+n)*log(m+n)) , space -> O(1) , EZ
  static void merge2(int[] arr1, int arr2[]) {
    int m = arr1.length;
    int n = arr2.length;
    int i = 0, j = 0, k = m - 1;
    while (i <= k && j < n) {
      if (arr1[i] < arr2[j]) i++; else {
        int temp = arr2[j];
        arr2[j] = arr1[k];
        arr1[k] = temp;
        j++;
        k--;
      }
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);
  }
}
