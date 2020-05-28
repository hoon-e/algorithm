package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

public class IterHeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 17, 9, 21};
        int len = arr.length;

        heapSort(arr, len);

        for(int n : arr)
            System.out.println(n);
    }

    // Make MaxHeap
    static void makeMaxHeap(int[] arr, int len){
        for(int i=1; i<len; i++){
            // 자식이 부모보다 큰 경우
            if(arr[i] > arr[(i-1)/2]){
                int temp = i;

                // 자식이 더 큰 동안 반복한다.
                while(temp > 0 && arr[temp] > arr[(temp-1)/2]){
                    swap(arr, temp, (temp-1)/2);
                    temp = (temp-1)/2;
                }
            }
        }
    }

    static void heapSort(int[] arr, int len){

        makeMaxHeap(arr, len);

        for(int i=len-1; i>0; i--) {
            // 첫번째 인덱스의 값과 마지막 인덱스를 교환한다.
            swap(arr, 0, i);

            // after swapping, maintaining heap property
            int temp = 0;
            int index = 0;

            do {
                index = (2 * temp) + 1;

                // if left child is smaller than right child,
                // then point index to right child
                // index가 left child를 나타내고, index+1이 right child를 나타낸다.
                if (index < (i - 1) && arr[index] < arr[index + 1])
                    ++index;

                // if parent is smaller than child, swapping
                if (index < i && arr[temp] < arr[index])
                    swap(arr, temp, index);

                temp = index;

            } while (index < i);
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
