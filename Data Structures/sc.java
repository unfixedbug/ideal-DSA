// package Data Structures;

public class sc {
    
}

class QuickSort {

    static int partition(int[] a, int start, int end) {
      int pivot = a[end];
  
      // elements less than pivotin left, right than pivot in the right
      // swap only if smaller element is present, take smaller element, swap it to the left
      int pIndex = start;
  
      // each time we find an element less than or equal to the pivot,
      // `pIndex` is incremented, and that element would be placed
      // before the pivot.
      for (int i = start; i < end; i++) {
        if (a[i] <= pivot) {
          swap(a, i, pIndex);
        }
      }
      // swap, pIndex,and pivot, cause pivot is smaller right!
      swap(a, pIndex, end);
      return pIndex;
    }
  
    //Quicksort , more like merge sort {Divide And Conquer}
    static void quickSort(int a[], int start, int end) {
      if (start >= end) return; // single element will be returned as sorted
  
      // rearrange elements across pivot
      int pivot = partition(a, start, end);
      // pivot is already sorted
      // recur on subarray containing elements less than the pivot
      quickSort(a, start, pivot - 1);
  
      // recur on subarray containing elements more than the pivot
      quickSort(a, pivot + 1, end);
    }
  
    static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  
    //driver code
    public static void main(String[] args) {
      int[] a = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };
  
      quickSort(a, 0, a.length - 1);
  
      // print the sorted array
      System.out.println(Arrays.toString(a));
    }
  }
  