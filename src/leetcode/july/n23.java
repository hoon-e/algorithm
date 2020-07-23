package leetcode.july;

import java.util.*;

public class n23 {
    // My Answer
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> number = new HashMap<>();
        int[] ans = new int[2];

        for(int n : nums)
            number.put(n, number.getOrDefault(n, 0)+1);

        int i = 0;
        for(int key : number.keySet()) {
            if(number.get(key) == 1)
                ans[i++] = key;
        }

        return ans;
    }

    // With Bit-change
    public int[] singleNumber2(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
