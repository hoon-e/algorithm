package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

/*
3 2
1 + 2, 2 + 1, 0 + 3, 3 + 0
 */
public class N2225 {
    static int N;
    static int K;
    static long[][] dp;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[K+1][N+1];

        for(int i=0; i<=N; i++)
            dp[1][i] = 1;

        for(int i=1; i<=K; i++){
            for(int j=0; j<=N; j++){
                for(int l=0; l<=j; l++){
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j] %= INF;
                }
            }
        }

        bw.write((dp[K][N] % INF)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
