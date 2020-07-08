package RE.dp;

import java.io.*;
import java.util.*;

public class n10844 {
    static int N;
    static int[][] dp;
    static final int INF = 1_000_000_000;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        dp = new int[10][N+1];

        for(int i=0; i < 10; i++)
            dp[i][1] = 1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                if(j-1 >= 0 && j+1 < 10)
                    dp[j][i] = (dp[j-1][i-1] + dp[j+1][i-1]) % INF;
                else if(j+1 >= 10)
                    dp[j][i] = (dp[j-1][i-1]) % INF;
                else
                    dp[j][i] = (dp[j+1][i-1]) % INF;
            }
        }

        int sum = 0;
        for(int j=1; j<10; j++){
            sum += dp[j][N];
            sum %= INF;
        }

        out.write(sum+"");
        out.flush();
        in.close();
        out.close();
    }
}
