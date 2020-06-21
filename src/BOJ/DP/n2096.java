package BOJ.DP;

import java.io.*;
import java.util.*;

public class n2096 {
    static int[][] number;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        number = new int[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            number[i][0] = Integer.parseInt(st.nextToken());
            number[i][1] = Integer.parseInt(st.nextToken());
            number[i][2] = Integer.parseInt(st.nextToken());
        }

        out.write(findMax(number) + " " + findMin(number));
        out.flush();

        in.close();
        out.close();
    }

    static int min(int a, int b){
        return (a < b) ? a : b;
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }

    static int findMax(int[][] number){
        int[][] dp = new int[N][3];

        for(int i=0; i<N; i++)
            System.arraycopy(number[i], 0, dp[i], 0, 3);

        for(int i=1; i<N; i++){
            dp[i][0] = max(dp[i-1][0] + dp[i][0], dp[i-1][1] + dp[i][0]);
            dp[i][1] = max(max(dp[i-1][0] + dp[i][1], dp[i-1][1] + dp[i][1]) , dp[i-1][2] + dp[i][1]);
            dp[i][2] = max(dp[i-1][2] + dp[i][2], dp[i-1][1] + dp[i][2]);
        }

        return max(max(dp[N-1][0], dp[N-1][1]) , dp[N-1][2]);
    }

    static int findMin(int[][] number){
        int[][] dp = new int[N][3];

        for(int i=0; i<N; i++)
            System.arraycopy(number[i], 0, dp[i], 0, 3);

        for(int i=1; i<N; i++){
            dp[i][0] = min(dp[i-1][0] + dp[i][0], dp[i-1][1] + dp[i][0]);
            dp[i][1] = min(min(dp[i-1][0] + dp[i][1], dp[i-1][1] + dp[i][1]) , dp[i-1][2] + dp[i][1]);
            dp[i][2] = min(dp[i-1][2] + dp[i][2], dp[i-1][1] + dp[i][2]);
        }

        return min(min(dp[N-1][0], dp[N-1][1]) , dp[N-1][2]);
    }
}
