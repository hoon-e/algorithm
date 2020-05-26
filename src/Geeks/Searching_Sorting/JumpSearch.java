package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

public class JumpSearch {
    // Binary Search와 마찬가지로, 정렬되어있는 알고리즘을 탐색한다.
    // Basic Idea : 선형 탐색보다 적은 요소를 탐색(특정 너비만큼 건너뛰면서)
    // Binary Search가 더 효율적이나, 가장 작은 요소를 탐색허가나 할때에는 더 효율적일 수도 있다.

    public static void main(String[] args) throws IOException {

        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};

        int target = 55;

        int index = jumpSearch(arr, target);
        System.out.println("The answer is : " + index);
    }

    // Worst Case : n/m jumps. 마지막으로 체크한 값보다 찾아야 하는 값이 더 큰 경우
    // Best Case : m = sqrt(n)

    static int jumpSearch(int[] arr, int x){
        int len = arr.length;

        // Finding Block Size
        int step = (int)Math.floor(Math.sqrt(len));

        int prev = 0;

        while(arr[Math.min(step, len)-1] < x){
            prev = step;
            step += step;
            if(prev >= len)
                return -1;
        }

        // 선형 탐색 시작 . prev서부터 시작
        while(arr[prev] < x){
            ++prev;

            if(prev == Math.min(step, len)){
                return -1;
            }
        }

        if(arr[prev] == x)
            return prev;

        return -1;
    }
}
