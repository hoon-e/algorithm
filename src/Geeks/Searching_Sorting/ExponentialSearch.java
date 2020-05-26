package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// Time Complexity : O(logn)
// Exponential Search는 범위가 정해져있지않은 탐색에 유리하다.(무한대이거나)
// 첫번째 원소와 가까울때 더 유용하다.

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        int result = exponentialSearch(arr, arr.length, target);
    }

    // 요소가 존재하는 범위를 구한다.
    // 찾은 범위 내에서 이분 탐색을 진행한다.

    /*
    요소의 범위를 어떻게 찾는가?
    subarray의 범위를 1부터 시작해서, target과 비교한다. 그리고 2로 증가, 4로 증가.
    하면서 마지막 원소와 비교한다.
     */

    static int exponentialSearch(int[] arr, int len, int target){
        if(arr[0] == target)
            return 0;

        // Find range for binarySearch by repeated doubling
        int i = 1;
        while(i < len && arr[i] <= target){
            i *= 2;
        }

        return Arrays.binarySearch(arr, i/2, Math.min(i, len), target);
    }
}
