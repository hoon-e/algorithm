package leetcode.august;

import java.util.*;
import java.io.*;

public class n4 {
    // MyAnswer
    public boolean isPowerOfFour(int num) {
        int target = 0b0100;

        if(num == 0) return false;
        if(num == 1) return true;
        for(int i=1; i<=16; i++)
            if((num&(target << 2*i)) == num) return true;

        return false;
    }

    public boolean isPowerOfFour2(int num) {
        return num > 0 &&
                (num & (num - 1)) == 0 &&
                (num & 0x55555555) != 0;
    }
}
