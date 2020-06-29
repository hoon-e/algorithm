package RE.dp;

import java.io.*;
import java.util.*;

public class n1463 {
    static int N;
    static int[] dp;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        dp = new int[N+1];

        Arrays.fill(dp, 1_000_000);

        dp[N] = 0;
        for(int i=N; i>=1; i--){
            if(i % 3 == 0)
                dp[i/3] = min(dp[i/3], dp[i] + 1);
            if(i % 2 == 0)
                dp[i/2] = min(dp[i/2], dp[i] + 1);

            dp[i-1] = min(dp[i-1], dp[i] + 1);
        }

        out.write(dp[1]+"");
        out.flush();
        in.close();
        out.close();
    }

    static int min(int a, int b){
        return (a < b) ? a : b;
    }
}
