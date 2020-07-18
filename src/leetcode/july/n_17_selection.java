package leetcode.july;

import java.io.*;
import java.util.*;

public class n_17_selection {
    // Selection sort example
    
    int[] unique; // 개별적인 원소의 집합
    Map<Integer, Integer> count;

    public void swap(int a, int b){
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_idx) {
        int pivot_freq = count.get(unique[pivot_idx]);
        
        // pivot을 끝으로 이동
        swap(pivot_idx, right);
        int temp_left = left;

        // pivot보다 더 적은 주기를 가지는 것을 왼쪽으로 이동
        for(int i=left; i<=right; i++) {
            if( count.get(unique[i]) < pivot_freq ) {
                swap( temp_left, i );
                temp_left++;
            }
        }

        swap(temp_left, right);
        return temp_left;
    }

    public void quickSelect(int left, int right, int kSmall) {
        // 길이가 1인 경우
        if( left == right ) return;

        // 랜덤 피봇을 선택
        Random random_num = new Random();
        int pivot_idx = left + random_num.nextInt(right - left);

        pivot_idx = partition(left, right, pivot_idx);

        if( kSmall == pivot_idx ) {
            return;
        } else if( kSmall < pivot_idx ) {
            quickSelect(left, pivot_idx - 1, kSmall);
        }else {
            quickSelect(pivot_idx + 1, right, kSmall);
        }
    }

    public int[] topKFreq(int[] nums, int k) {
        count = new HashMap<>();

        for(int num : nums)
            count.put(num, count.getOrDefault(num, 0)+1);

        int n = count.size();
        unique = new int[n];

        int i = 0;

        for(int num : count.keySet())
            unique[i++] = num;

        quickSelect(0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }
}
