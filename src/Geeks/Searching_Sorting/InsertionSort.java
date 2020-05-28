package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// Time Complexity : O(n^2)
// Stable : Yes

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);

        for(int w : arr)
            System.out.println(w);
    }

    static void insertionSort(int[] arr){
        int len = arr.length;

        for(int i=1; i<len; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                --j;
            }

            arr[j+1] = key;
        }
    }
}
