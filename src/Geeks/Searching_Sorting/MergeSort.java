package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// Time Complexity : O(nlogn)
// Stable : Yes

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length-1);

        for(int a : arr)
            System.out.print(a + " ");
    }

    static void merge(int[] arr, int left, int mid, int right){
        // 합쳐야 할 사이즈 정의
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftSub = new int[leftSize];
        int[] rightSub = new int[rightSize];

        // copyData
        for(int i=0; i<leftSize; i++)
            leftSub[i] = arr[left+i];
        for(int i=0; i<rightSize; i++){
            rightSub[i] = arr[mid+i+1];
        }

        // Initial subarray's index
        int i=0, j = 0;

        // Initial mergearray's index
        int m = left;
        while(i < leftSize && j < rightSize){
            if(leftSub[i] <= rightSub[j]){
                arr[m++] = leftSub[i++];
            }else{
                arr[m++] = rightSub[j++];
            }
        }

        // remains

        while(i < leftSize){
            arr[m++] = leftSub[i++];
        }

        while(j < rightSize){
            arr[m++] = rightSub[j++];
        }
    }

    static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
}
