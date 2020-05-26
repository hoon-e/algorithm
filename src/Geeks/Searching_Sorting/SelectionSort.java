package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// 반복적으로 최소값을 찾으면서 배열을 정렬하는 알고리즘
// 최소값을 배열의 가장 앞쪽에 놓으면서 정리한다.

// Time Complexity : O(n^2)

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        for(int n : arr)
            System.out.println(n);
    }

    static void stableSelectionSort(int[] arr, int n){
        // Iterate through array elements
        for(int i=0; i<n-1; i++){
            // Loop invariant : Elements till
            // a[i-1] is already sorted.

            // Find Minimum element from arr[i] to arr[n-1]
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[min] > arr[j])
                    min = j;
            }

            // Moving Back from current i
            int key = arr[min];
            while(min > i){
                arr[min] = arr[min-1];
                --min;
            }

            arr[i] = key;
        }
    }

    static void selectionSort(int[] arr){
        int len = arr.length;

        for(int i = 0; i < len - 1; i++){
            int min_idx = i;

            for(int j=i+1; j<len; j++){
                if(arr[j] < arr[min_idx])
                    min_idx = j;
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
