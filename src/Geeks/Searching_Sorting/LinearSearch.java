package Geeks.Searching_Sorting;

import java.io.*;

public class LinearSearch {
    public static void main(String[] args) throws IOException {

        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;

        int result = search(arr, x);

        if(result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }

    static int search(int[] arr, int x){
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i] == x)
                return i;
        }
        return -1;
    }

    // Time Complexity : O(n)
}
