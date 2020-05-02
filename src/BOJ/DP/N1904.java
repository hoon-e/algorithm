package BOJ.DP;

import java.io.*;

public class N1904 {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        if(N == 1) {
            dp[1] = 1;
        }
        else if(N == 2) {
            dp[1] = 1;
            dp[2] = 2;
        }
        else if(N >= 3) {
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
        }

        bw.write((dp[N]%15746)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}