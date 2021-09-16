// arr[i-1/2]  --> parent of the node
// arr[i*2 +1] --> left child of the node
// arr[i*2 +2] --> right child of the node

class maxheap {
    public static void main(String[] args) {

    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // delete the root;
    static int deleteroot(int arr[], int n) {
        int lastelement = arr[n - 1];
        arr[0] = arr[n - 1];
        n = n - 1; /// decrease the size of the array
        return n;
    }
}