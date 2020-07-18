package leetcode.july;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class n17 {
    /* trendy code
    public static int[] topKFrequentAns(int[] nums, int k){
        if( k == nums.length ){
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);

        // PriorityQueue에 count의 get으로 정렬하겠다는 것을 명시
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(count::get)
        );


        for(int n : count.keySet()) {
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }

        // O(klogk)
        int[] top = new int[k];
        for(int i=k-1; i>=0; i--)
            top[i] = heap.poll();

        return top;
    }
    */

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
