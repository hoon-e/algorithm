package leetcode.july;

import java.util.*;

public class n25 {
    public int findMin(int[] nums) {
        int pivot = nums[0];
        boolean flag = false;

        for(int i=1; i<nums.length; i++){
            if(pivot <= nums[i]){
                pivot = nums[i];
            }else {
                pivot = nums[i];
                flag = true;
                break;
            }
        }

        return flag ? pivot : nums[0];
    }
}
