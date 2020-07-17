package leetcode.july;

import java.io.*;
import java.util.*;

public class n16 {
    public double myPow(double x, int n) {
        double ans = 0;
        if(n < 0){
            n *= -1;
            ans = 1 / Math.pow(x, n);

            if( ans == Double.POSITIVE_INFINITY )
                ans = 0;
        }else {
            ans = Math.pow(x, n);
        }

        return ans;
    }
}
