package RE.dp;

import java.util.*;
import java.io.*;

public class n8320 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        long[] dp = new long[n+1];
        int[] num = new int[n+1];

        for(int i=4; i<=n; i++){
            for(int j=2; j<=(int)Math.sqrt(i); j++) {
                if (i % j == 0) ++num[i];
            }
        }

        dp[1] = 1;
        for(int i=2; i<=n; i++)
            dp[i] = (dp[i-1] + num[i] + 1);

        System.out.println(dp[n]);
    }
}
