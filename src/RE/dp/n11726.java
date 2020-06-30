package RE.dp;

import java.io.*;
import java.util.*;

public class n11726 {
    static long[] dp;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        dp = new long[1001];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        out.write((dp[n] % 10007) +"\n");
        out.flush();
        in.close();
        out.close();
    }
}
