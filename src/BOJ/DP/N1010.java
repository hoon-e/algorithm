package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N1010 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        long[][] dp = new long[31][31];

        for(int i=0; i<=30; i++){
            dp[i][0] = dp[i][i] = 1;
            for(int j=1; j < i; j++)
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }

        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            bw.write(dp[M][N]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
