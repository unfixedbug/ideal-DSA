package Algorithms.sortings;

// insert the element in the correct position , going backwards, sorted elements are present in the front
//O(n^2)
public class InsertionSort {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            int j=i;


            // find index `j` within the sorted subset `arr[0…i-1]`
            // where element `arr[i]` belongs
            while(j>0 && arr[j-1]>value){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=value;

        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

    }
}
