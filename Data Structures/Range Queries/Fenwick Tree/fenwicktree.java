
/**
 * fenwicktree
 * Binary indexed Tree (BIT) implementation
 * works same as segment tree (faster)
 * 
 * 
 * point update, point query
 * range update, range query
 * 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class fenwicktree {

    final static int MAX = 1000;
    static int BIT[] = new int[MAX];

    // point update
    void update(int n, int index, int value) {
        index = index + 1;
        while (index <= n) {
            BIT[index] += value;
            index += index & (-index);
        }
    }

    // range update
    void updateRange(int l, int r, int value, int n) {
        // inrease value at 'l' by 'val'
        update(n, l, value);
        // decrease value at 'r' by 'val'
        update(n, r + 1, -value);
    }

    // point query
    int getSum(int index) { /// returns sum from arr[0] to arr[index]

        int sum = 0;
        // btree starts from 1
        index = index + 1;
        while (index > 0) {
            sum += BIT[index];

            // move index to parent node
            index -= index & (-index);
        }
        return sum;
    }

    // returns sum from arr[0] to arr[n-1]
    int getSum() {
        return getSum(MAX - 1);
    }

    // range query
    int getSum(int l, int r) {
        return getSum(r) - getSum(l - 1);
    }

    void ConstructBtree(int arr[], int n) {
        for (int i = 1; i <= n; i++) {
            BIT[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            update(n, i, arr[i]);
        }
    }

    // drivercode
}