package Geeks.dp;

import java.io.*;
import java.util.*;

/*
 Find the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 */

public class LIS {

    static int lis(int[] arr, int len){
        int[] list = new int[len];
        int max = 0;

        Arrays.fill(list, 1);

        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && list[i] < list[j] + 1){
                    list[i] = list[j] + 1;
                }
            }
        }

        for(int i=0; i<len; i++){
            max = Math.max(max, list[i]);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

        int len = arr.length;

        out.write(lis(arr, len)+"\n");
        out.flush();
        in.close();
        out.close();
    }
}
