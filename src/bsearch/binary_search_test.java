package bsearch;

import java.io.*;
import java.util.Arrays;

public class binary_search_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num = {11, 4, 5, 7, 9, 1, 20, 35, 40};

        for(int i=0; i<num.length; i++){
            int idx = Arrays.binarySearch(num, 0, num.length, num[num.length-1-i]);
            System.out.println(idx);
        }
    }
}
