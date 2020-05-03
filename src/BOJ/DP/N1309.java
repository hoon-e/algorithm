package BOJ.DP;

import java.io.*;

public class N1309 {
    static int N;
    static long[] dp;
    static final int mod = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        dp[0] = 1;
        dp[1] = 3;

        for(int i=2; i<=N; i++){
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % mod;
        }

        bw.write((dp[N] % mod) +"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
