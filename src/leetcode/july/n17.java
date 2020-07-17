package leetcode.july;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class n17 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int[] ans = new int[2];

        for ( int num : nums ) {
            if ( freq.get(num) == null ) {
                freq.put(num, 1);
            } else {
                int val = freq.get(num);
                freq.put(num, val + 1);
            }
        }

         List<Map.Entry<Integer, Integer>> answer = freq.entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue())
                 .collect(Collectors.toList());

        int cnt = 0;
        for(Map.Entry<Integer, Integer> item : answer){
            ans[cnt] = item.getKey();
            if(cnt == k)
                break;
        }

        return ans;
    }
}
