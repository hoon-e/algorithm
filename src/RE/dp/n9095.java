package RE.dp;

import java.io.*;
import java.util.*;

public class n9095 {
    static int T;
    static int n;
    static int[] dp = new int[12];
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(in.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<12; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]);
        }

        while(T-- > 0){
            n = Integer.parseInt(in.readLine());
            out.write(dp[n]+"\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
