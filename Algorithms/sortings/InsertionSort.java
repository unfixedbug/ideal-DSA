package Algorithms.sortings;

// insert the element int the correct position , going backwards, sorted elements are present in tthe front
//O(n^2)
public class InsertionSort {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) { // we consider the first element to be already sorted, 0th position
            int key = arr[i];
            int j = i - 1;

            /* move j -> j+1 , who are greater than the key */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // ye dekho aage shift kr diya na
                j--; // aaur peeche jaao bro!
            }
            arr[j + 1] = key; // key is the element to be inserted
            // inserted key at its correct position
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

    }
}
