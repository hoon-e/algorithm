package SWEA.before;

import java.io.*;
import java.util.*;

public class maxDivision {
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[] numbers = new int[n+2];
        int[][] dp = new int[n+2][n+2];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i=1; i<=n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = numbers[i];
        }

        int max = -1;
        int start = 0;
        int end = 0;

        for(int i=1; i<n+2; i++){
            for(int j=i+1; j<n+2; j++){
                dp[i][j] += dp[i][j-1];

                if(dp[i][j] > max) {
                    max = dp[i][j];
                    start = i;
                    end = j;
                }
            }
        }

        out.write("Max sum is : " + max + "\nDivision is " + start + " to " + end);
        out.flush();
        in.close();
        out.close();
    }
}
