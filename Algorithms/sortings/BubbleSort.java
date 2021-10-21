package Algorithms.sortings;

// repeatedly swapping adjacent elements that are out of order
public class BubbleSort {
    void sort(int arr[]) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) { // last element will be at corrct position
                if (arr[j] > arr[j + 1]) {
                    // swap the elements;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            //there will be now swap in already sorted array
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        BubbleSort bb = new BubbleSort();
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        bb.sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
