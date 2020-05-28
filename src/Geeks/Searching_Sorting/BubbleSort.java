package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// Swapping adjacent elements
// Optimizing bubbleSort
// Worst and Average Case Time Complexity : O(n^2)
// Stable : Yes

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);

        for(int n : arr)
            System.out.println(n);
    }

    static void bubbleSort(int[] arr){
        int len = arr.length;
        boolean swapped;

        for(int i=0; i<len-1; i++){
            swapped = false;
            for(int j=0; j<len-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }
    }
}
