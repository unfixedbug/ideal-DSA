package crucial;

// https://www.youtube.com/watch?v=gcYvFVZ_LUA
public class BinarySearch {

    public static void main(String[] args) {
        int marks[] = {}
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

    if(arr[lo]>=ele)return lo;
    if(arr[hi]>=ele)return hi; // just greater element
    else return -1;// present hi nahi h
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

    if(arr[lo]>ele)return lo;
    if(arr[hi]>ele)return hi; // just greater element
    else return -1;// present hi nahi h}
}
}