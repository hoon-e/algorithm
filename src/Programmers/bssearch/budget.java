package Programmers.bssearch;

import java.io.*;

import java.util.*;

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;

        Arrays.sort(budgets);

        answer = binarySearch(budgets, M);

        return answer;
    }

    public long getTarget(int[] budgets, int mid){
        long target = 0;
        for(int i=0; i < budgets.length; i++){
            if(budgets[i] <= mid)
                target += budgets[i];
            else
                target += mid;
        }

        return target;
    }

    public int binarySearch(int[] budgets, int target){
        int start = 0;
        int end = budgets[budgets.length-1];
        int mid = 0;

        while(start <= end){
            mid = (start+end)/2;
            long budget = getTarget(budgets, mid);

            if(budget < target){
                start = mid + 1;
            }else if(budget > target){
                end = mid - 1;
            }else{
                end = mid;
                break;
            }
        }

        return end;
    }
}
