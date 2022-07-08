/*
1) max heap easy to implement (but not efficient)
    takes O(nlogn) time, same as sorting

this needs to be done with QUICKSELECT algorithm 
which runs in O(n) time and O(1) space

// watch quicksort EZ
*/

class KthSmallestElement {

  // k is the relative kth position
  int kthSmallest(int arr[], int l, int r, int k) {
    // k is smaller than =length of array
    if (k > 0 && k <= r - l + 1) {
      // gives index of the pivot element, whose left is sorted, right is sorted
      int pos = randomPartition(arr, l, r);

      // if the current position is the kth position, return the element
      if (pos - l == k - 1) return arr[pos];

      // if [l ... k...pos ..r]
      // number of elements in left subarray is greater than k, k lies between left subarray
      if (pos - l > k - 1) {
        return kthSmallest(arr, l, pos - 1, k);
      }
      // recur right side of array with, relative k position
      return kthSmallest(arr, pos + 1, r, k - (pos - l) - 1);
      // if [l ...pos...k....r]
    }
    // if k is greater than length of array, return -1
    return -1;
  }

  // partition the array around the pivot element
  // first get random element between l,r and make it pivot
  // move it to the end of the array
  // then partition the array around the pivot element

  int randomPartition(int arr[], int l, int r) {
    // get number between l,r
    int random = getPivot(arr, l, r);
    // move pivot to the end of the array
    swap(arr, random, r);
    // partition the array around the pivot element
    int pivot = arr[r]; // which is actually the last element of the array, we set as pivot
    int pIndex = l;
    for (int i = l; i < r; i++) {
      if (arr[i] <= pivot) {
        swap(arr, i, pIndex);
        pIndex++;
      }
    }
    swap(arr, pIndex, r);
    return pIndex;
  }

  int getPivot(int arr[], int l, int r) {
    // get number between l,r
    int lengthOfWindow = r - l + 1;
    int randomNumber = (int) (Math.random() * (lengthOfWindow - 1));
    return l + randomNumber;
  }

  void swap(int arr[], int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }
}
