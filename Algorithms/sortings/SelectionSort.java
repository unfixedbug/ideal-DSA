package Algorithms.sortings;

//O(n^2)
// find the minimum element, put it at first
public class SelectionSort {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // exceprt the last element
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // swap the found minimum element with the first element;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        SelectionSort ss = new SelectionSort();
        ss.sort(arr);
        // arrray arr is sorted now
    }
}
