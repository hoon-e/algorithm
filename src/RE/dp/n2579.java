package RE.dp;

import java.io.*;
import java.util.*;

public class n2579 {
    static int N;
    static int[] stairs;
    static int[][] dp;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        stairs = new int[N+1];
        dp = new int[N+1][3];

        for(int i=1; i<=N; i++){
            stairs[i] = Integer.parseInt(in.readLine());
        }

        dp[1][1] = stairs[1];
        dp[1][2] = 0;

        for(int i=2; i<=N; i++){
            if( i < 3 ){
                dp[i][1] = max(dp[i-1][1] + stairs[i], dp[i][1]);
                dp[i][2] = max(dp[i-1][2] + stairs[i], dp[i][2]);
            }else {
                dp[i][1] = max(dp[i-1][2] + stairs[i], dp[i][1]);
                dp[i][2] = max(max(dp[i-2][1], dp[i-2][2]) + stairs[i], dp[i][2]);
            }
        }

        out.write(max(dp[N][1], dp[N][2])+"");
        out.flush();
        in.close();
        out.close();
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
