// https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
public class negativePositiveSorting {

  public static void main(String[] args) {
    int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
    quickSelectPartition(arr);
    for (int e : arr) System.out.print(e + " ");
  }

  private static void quickSelectPartition(int arr[]) {
    int i = 0;
    int mid = 0;

    while (mid < arr.length) {
      if (arr[mid] < 0) {
        swap(arr, i, mid);
        mid++;
        i++;
      } else {
        mid++;
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

class sort {

  public static void main(String[] args) {

    int[] arr = { -1, 2, -3, 4,0,0,0, 5, 6, -7, 8, 9 };
    QuickSort(arr,0,arr.length-1);
    for (int e : arr) System.out.print(e + " ");
  }

  private static void QuickSort(int arr[], int l, int r) {
    if (l < r) {
      int p = partition(arr, l, r);
      QuickSort(arr, l, p - 1);
      QuickSort(arr, p + 1, r);
    }
  }

  private static int partition(int arr[], int l, int r) {
    int pivot = arr[r]; // last element as pivot

    int i = l - 1;

    for (int j = l; j < r; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, r);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
