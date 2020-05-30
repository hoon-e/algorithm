package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// MergeSort와 같이 Divide Conquer 알고리즘이다.
/*
pivot을 정하는 방법
1. 항상 첫번째를 pivot으로 정하는 법
2. 항상 마지막을 pivot으로 정하는 법
3. 랜덤 요소를 pivot으로 정한다.
4. 중간값을 pivot으로
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int len = arr.length;

        quickSort(arr, 0, len-1);

        for(int a : arr)
            System.out.println(a);
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int index = (low-1);

        for(int i=low; i<high; i++){
            if(arr[i] < pivot){
                ++index;

                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[index+1];
        arr[index+1] = arr[high];
        arr[high] = temp;

        return index+1;
    }

    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);

            // before pivot and after pivot
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
}
