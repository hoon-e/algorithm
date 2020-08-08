package leetcode.august;

import java.util.*;
import java.io.*;

public class n6 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int[] flag = new int[nums.length+1];

        for(int n : nums) ++flag[n];

        for(int i=1; i<=nums.length; i++){
            if(flag[i] == 2) ans.add(i);
        }
        return ans;
    }
}
