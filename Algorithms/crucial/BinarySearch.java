// package crucial;
/*
 * find first and last occurance of element in sorted array
 * occurance of element in sorted array
 * binary search imp
 */
// https://www.youtube.com/watch?v=gcYvFVZ_LUA
public class BinarySearch {

  public static void main(String[] args) {
    int marks[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  }

  //if element is present, then return the index of just greater element
  static int lowerBound(int arr[], int ele) {
    int lo = 0, hi = arr.length - 1;

    while (hi - lo > 1) {
      int mid = (hi + lo) / 2;
      if (arr[mid] < ele) {
        lo = mid + 1; // excluded mid
      } else { // v[mid] >= ele
        hi = mid; // we wont exclude mid
      }
    }

    if (arr[lo] >= ele) return lo;
    if (arr[hi] >= ele) return hi; // just greater element
    else return -1; // present hi nahi h
  }

  // strictly greater than the element
  static int upperBound(int arr[], int ele) {
    int lo = 0, hi = arr.length - 1;
    while (hi - lo > 1) {
      int mid = (hi + lo) / 2;
      if (arr[mid] <= ele) {
        lo = mid + 1; // excluded mid
      } else { // v[mid] >= ele
        hi = mid; // we wont exclude mid
      }
    }

    if (arr[lo] > ele) return lo;
    if (arr[hi] > ele) return hi; // just greater element
    else return -1; // present hi nahi h}
  }

  // first occurance of element in sorted array
  private static int firstocc(int arr[], int x) {
    int low = 0, high = arr.length - 1;
    int res = -1;
    while (low <= high) {
      int mid = (low + high) >> 1;
      if (arr[mid] > x) {
        high = mid - 1;
      } else if (arr[mid] < x) {
        low = mid + 1;
      }
      // if mid is same as x, then, check to the left also
      else {
        res = mid;
        high = mid - 1;
      }
    }
    return res;
  }
}
