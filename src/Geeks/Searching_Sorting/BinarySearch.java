package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

// Time complexity : T(n) = T(n/2) + C

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int n = arr.length;
        int target = 41;

        int result = BinarySearch_Recur(arr, 0, n-1, target);
        int result2 = BinarySearch_Iter(arr, target);

        System.out.println(result);
        System.out.println(result2);
    }

    static int BinarySearch_Recur(int[] arr, int start, int end, int target){
        if(start >= 1){
            int middle = (start + (end-1)) / 2;

            // 중간에 위치한다면
            if(arr[middle] == target)
                return middle;
            
            // 중간의 값보다 작다면
            if(arr[middle] > target)
                return BinarySearch_Recur(arr, start, middle-1, target);

            return BinarySearch_Recur(arr, middle+1, end, target);
        }

        return -1;
    }

    static int BinarySearch_Iter(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid] == target)
                return mid;
            if(arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -(start);
    }
}
