package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// Heap Sort
// 배열로 Heap을 간단하게 구현할 수 있다. - 인덱스가 0부터 시작한다는 가정하에, 왼쪽 자식을 2*i+1, 오른쪽을 2*i+2

// 주어진 데이터를 통해 Max Heap을 구현한다.
// 가장 큰 데이터가 Root로 향한다.
// 힙의 사이즈가 1보다 클 때까지 반복한다.

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int len = arr.length;
        heapSort(arr);

        for(int a : arr)
            System.out.print(a + " ");
    }

    static void heapSort(int[] arr){
        int len = arr.length;

        // Make Heap
        for(int i=(len/2)-1; i>=0; i--){
            heapify(arr, len, i);
        }

        // Elements out from heap
        for(int i=len-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // remake Heap
            heapify(arr, i, 0);
        }
    }

    // subtree를 제작하는 함수
    static void heapify(int[] arr, int len, int index){
        int largest = index; // largest를 root로 지정한다.
        int left = 2*index + 1;
        int right = 2*index + 2;
        
        // 왼쪽 자식이 루트보다 클 경우
        if(left < len && arr[left] > arr[largest])
            largest = left;
        
        // 오른쪽 자식이 루트보다 클 경우
        if(right < len && arr[right] > arr[largest])
            largest = right;

        if(largest != index) { // 초기 index와 root가 다를 경우
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            // 재귀적으로 heap을 생성한다.
            heapify(arr, len, largest);
        }
    }
}
